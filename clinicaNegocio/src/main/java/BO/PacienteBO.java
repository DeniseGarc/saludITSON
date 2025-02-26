package BO;
import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import DTO.DireccionDTO;
import DTO.PacienteActualizarDTO;
import DTO.PacienteDTO;
import DAO.UsuarioDAO;
import Encriptado.Encriptador;
import Encriptado.IEncriptador;
import Mapper.PacienteMapper;
import Mapper.UsuarioMapper;
import conexion.IConexion;
import entidades.Paciente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.IUsuarioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author joelr
 */
public class PacienteBO {

    private final IEncriptador encriptador = new Encriptador();
    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    private final IPacienteDAO pacienteDAO;
    private final IUsuarioDAO usuarioDAO;
    private final PacienteMapper mapperPaciente = new PacienteMapper();
    private final UsuarioMapper mapperUsuario = new UsuarioMapper();

    public PacienteBO(IConexion conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    /**
     * Agrega registra un paciente en la base de datos usando un DTO
     * (PacienteDTO).
     *
     * @param pacienteNuevo Objeto DTO que contiene la información del paciente
     *                      a agregar.
     * @return boolean Devuelve true si el paciente se agregó correctamente,
     *         false en caso contrario.
     * @throws NegocioException Si hay problemas en las capas.
     */
    public boolean registrarPaciente(PacienteDTO pacienteNuevo) throws NegocioException {
        // Validar que el paciente no sea nulo.
        if (pacienteNuevo == null) {
            logger.severe("Error: El paciente es nulo");
            return false;
        }
        // se realiza la validacion de los datos
        String mensaje = validarDatosPaciente(pacienteNuevo);
        if (!mensaje.equals("validos")) {
            throw new NegocioException(mensaje);
        }
        try {

            // Validar que no haya otro usuario con el mismo correo
            if (usuarioDAO.consultarUsuarioPorCorreo(pacienteNuevo.getCorreo()) != null) {
                throw new NegocioException("El correo ingresado ya se encuentra asociado a otro usuario");
            }

            // validar que no haya otro paciente con el mismo telefono
            if (pacienteDAO.consultarPacientePorTelefono(pacienteNuevo.getTelefono())) {
                throw new NegocioException("El teléfono ingresado ya se encuentra asociado a otro paciente");
            }

            // Uso de Mapper para convertir a Entidad y Encriptación de contraseña.
            Paciente paciente = mapperPaciente.convertirAEntidad(pacienteNuevo);
            String contrasenaEncriptada = encriptador.encriptar(pacienteNuevo.getContrasenaUsuario());
            paciente.setContrasenaUsuario(contrasenaEncriptada);
            // Registrar
            Paciente pacienteAGuardar = pacienteDAO.registrarPaciente(paciente);
            return pacienteAGuardar != null;
        } catch (PersistenciaException pe) {
            // Registro de error con el logger
            logger.log(Level.SEVERE, "Error: error al guardar paciente en la base de datos", pe);
            // Muestra excepcion con un mensaje
            throw new NegocioException("Error al intentar registrar en el sistema.");
        }
    }

    /**
     * Metodo que valida los datos del paciente, si uno de los datos introducidos no
     * cumple con los
     * requerimientos, devuelve el error correspondiente.
     * 
     * @param paciente
     * @return
     */
    private String validarDatosPaciente(PacienteDTO paciente) {
        String nombresPaciente = paciente.getNombresPaciente();
        String apellidoPaternoPaciente = paciente.getApellidoPaternoPaciente();
        String apellidoMaternoPaciente = paciente.getApellidoMaternoPaciente();
        String correo = paciente.getCorreo();
        String telefono = paciente.getTelefono();
        LocalDate fechaNacimiento = paciente.getFechaNacimiento();
        String calle = paciente.getCalle();
        String numero = paciente.getNumero();
        String colonia = paciente.getColonia();
        String codigoPostal = paciente.getCodigoPostal();

        // Verificar que los campos no esten vacios o sean nulos
        if (!esCampoValido(nombresPaciente) || !esCampoValido(apellidoPaternoPaciente)
                || !esCampoValido(apellidoMaternoPaciente) || !esCampoValido(correo)
                || !esCampoValido(telefono) || !esCampoValido(calle)
                || !esCampoValido(numero) || !esCampoValido(colonia)
                || !esCampoValido(codigoPostal) || fechaNacimiento == null) {
            return "Se ha dejado algún campo en blanco";
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            return "La fecha de nacimiento no puede ser en el futuro";
        }

        if (!numero.matches("\\d{1,10}")) {
            return "El número de casa debe de ser númerico, no mayor a 10 digitos";
        }

        if (!codigoPostal.matches("\\d{5}")) {
            return "El código postal debe ser de 5 digitos";
        }

        if (!telefono.matches("\\d{1,10}")) {
            return "El teléfono debe ser númerico y de máximo 10 digitos";
        }
        if (correo.length() > 100) {
            return "El correo electrónico no debe exceder los 100 caracteres";
        }
        if (!correo.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "El correo electrónico ingresado no está en el formato correcto";
        }
        if (!nombresPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+")
                || !apellidoPaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")
                || !apellidoMaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")) {
            return "Nombre en formato incorrecto, puede ingresar sus nombres pero solo ingrese un apellido por campo";
        }

        return "validos";
    }

//    /*
//     * Metodo que se encarga de validar que el correo y la contraseña existen.
//     * Si si existen en la base de datos, el paciente se logea.
//     * Muestra un error correspondiente en caso contrario.
//     */
//    public int Login(String correo, String contrasena) throws NegocioException, PersistenciaException {
//        try {
//
//            // Validar que los campos no esten vacios.
//            if (correo == null || contrasena == null) {
//                throw new NegocioException(
//                        "Error: El correo o la contraseña son incorrectos o no se encuentran registados");
//
//            } else if (correo.isEmpty() || contrasena.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Error: Los campos estan vacios.");
//                return 0;
//            } else {
//                int id = pacienteDAO.consultarIDPacientePorContrasenaCorreo(correo, contrasena);
//                return id;
//            }
//
//        } catch (NegocioException pe) {
//            // Registro de error con el logger
//            logger.log(Level.SEVERE, "Error: error al obtener el ID en la base de datos", pe);
//            // Muestra excepcion con un mensaje
//
//            throw new NegocioException("Error al intentar registrar en el sistema.");
//
//        }
//    }
    
    /**
    * Verifica si un campo es válido (no nulo ni vacío).
    *
    * @param campo El campo a verificar.
    * @return true si el campo es válido, false en caso contrario.
    */
    public static boolean esCampoValido(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }
    /**
    * Obtiene el nombre completo de un paciente dado su ID.
    *
    * @param idPaciente El identificador del paciente.
    * @return El nombre completo del paciente.
    * @throws NegocioException Si ocurre un error al consultar el nombre del paciente.
    */
    public String obtenerNombreCompletoPaciente(int idPaciente) throws NegocioException {
        try {
            return pacienteDAO.consultarNombreCompletoPaciente(idPaciente);
        } catch (PersistenciaException e) {
            throw new NegocioException(null + e.getMessage(), e);
        }
    }
    /**
    * Valida los datos de un paciente para su actualización.
    *
    * @param paciente El objeto que contiene los datos del paciente a actualizar.
    * @return Un mensaje de error si algún dato es inválido, o "validos" si todos los datos son correctos.
    */
    private String validarDatosPacienteActualizar(PacienteActualizarDTO paciente) {
        String nombresPaciente = paciente.getNombresPaciente();
        String apellidoPaternoPaciente = paciente.getApellidoPaternoPaciente();
        String apellidoMaternoPaciente = paciente.getApellidoMaternoPaciente();
        String telefono = paciente.getTelefono();
        LocalDate fechaNacimiento = paciente.getFechaNacimiento();
        DireccionDTO direccion = paciente.getDireccion();
        String calle = direccion.getCalle();
        String numero = direccion.getNumero();
        String colonia = direccion.getColonia();
        String codigoPostal = direccion.getCodigoPostal();

        if (!esCampoValido(nombresPaciente) || !esCampoValido(apellidoPaternoPaciente)
                || !esCampoValido(apellidoMaternoPaciente) || !esCampoValido(telefono)
                || !esCampoValido(calle) || !esCampoValido(numero) || !esCampoValido(colonia)
                || !esCampoValido(codigoPostal) || fechaNacimiento == null) {
            return "Se ha dejado algún campo en blanco";
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            return "La fecha de nacimiento no puede ser en el futuro";
        }

        if (!numero.matches("\\d{1,10}")) {
            return "El número de casa debe de ser numérico, no mayor a 10 dígitos";
        }

        if (!codigoPostal.matches("\\d{5}")) {
            return "El código postal debe ser de 5 dígitos";
        }

        if (!telefono.matches("\\d{1,10}")) {
            return "El teléfono debe ser numérico y de máximo 10 dígitos";
        }

        if (nombresPaciente.length() > 100 || apellidoPaternoPaciente.length() > 50
                || apellidoMaternoPaciente.length() > 50) {
            return "Los nombres y apellidos no deben exceder los 100 y 50 caracteres, respectivamente";
        }

        if (!nombresPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+")
                || !apellidoPaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")
                || !apellidoMaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")) {
            return "Nombre en formato incorrecto, solo ingrese letras y un espacio entre los nombres";
        }

        if (calle.length() > 100 || colonia.length() > 50) {
            return "La calle y la colonia no deben exceder los 100 y 50 caracteres respectivamente";
        }
        return "validos";
    }
    /**
    * Actualiza los datos de un paciente, previa validación y verificación de citas activas.
    *
    * @param pacienteDTO El objeto con los datos a actualizar del paciente.
    * @return true si la actualización fue exitosa, code false en caso contrario.
    * @throws NegocioException Si los datos del paciente son inválidos, o si el paciente tiene citas activas.
    */
    public boolean actualizarPaciente(PacienteActualizarDTO pacienteDTO) throws NegocioException {
        try {
            if (pacienteDTO == null) {
                throw new NegocioException("El paciente no puede ser nulo");
            }
            String mensaje = validarDatosPacienteActualizar(pacienteDTO);
            if (!mensaje.equals("validos")) {
                throw new NegocioException(mensaje);
            }
            if (pacienteDAO.tieneCitasActivas(pacienteDTO.getIdPaciente())) {
                throw new NegocioException("No se puede actualizar: el paciente tiene citas activas");
            }
            return pacienteDAO.actualizarPaciente(mapperPaciente.convertirAEntidad(pacienteDTO));

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
    * Obtiene el ID de la dirección de un paciente.
    *
    * @param idPaciente El ID del paciente.
    * @return El ID de la dirección del paciente.
    * @throws NegocioException Si ocurre un error al obtener el ID de la dirección.
    */
    public int obtenerIdDireccionPorPaciente(int idPaciente) throws NegocioException {
        try {
            return pacienteDAO.obtenerIdDireccionPorPaciente(idPaciente);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el ID de la dirección: " + e.getMessage());
        }
    }
    /**
    * Obtiene los datos de un paciente por su ID.
    *
    * @param idPaciente El ID del paciente.
    * @return Un objeto PacienteActualizarDTO con los datos del paciente.
    * @throws NegocioException Si ocurre un error al obtener los datos o si el paciente no existe.
    */
    public PacienteActualizarDTO obtenerDatosPaciente(int idPaciente) throws NegocioException {
        try {
            Paciente paciente = pacienteDAO.obtenerDatosPaciente(idPaciente);
            if (paciente == null) {
                throw new NegocioException("No se encontró un paciente con el ID: " + idPaciente);
            }
            return mapperPaciente.convertirAPacienteActualizarDTO(paciente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los datos del paciente: " + e.getMessage(), e);
        }
    }

}
