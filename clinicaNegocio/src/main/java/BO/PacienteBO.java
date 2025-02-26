/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    /**
     * Constructor que inicializa los DAOs de pacientes y usuarios.
     * 
     * @param conexion La conexión utilizada para acceder a la base de datos.
     */
    public PacienteBO(IConexion conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    /**
     * Agrega registra un paciente en la base de datos usando un DTO
     * (PacienteDTO).
     *
     * @param pacienteNuevo Objeto DTO que contiene la información del paciente
     * a agregar.
     * @return boolean Devuelve true si el paciente se agregó correctamente,
     * false en caso contrario.
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
     * Valida los datos del paciente.
     * 
     * @param paciente Objeto DTO que contiene la información del paciente a validar.
     * @return Un mensaje que indica si los datos son válidos o describe el error encontrado.
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
        if (!nombresPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+") || !apellidoPaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+") || !apellidoMaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")) {
            return "Nombre en formato incorrecto, puede ingresar sus nombres pero solo ingrese un apellido por campo";
        }

        return "validos";
    }
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
     * @param idPaciente El ID del paciente.
     * @return El nombre completo del paciente.
     * @throws NegocioException Si ocurre un error al obtener el nombre completo del paciente.
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
     * @param paciente Objeto DTO que contiene la información del paciente a validar.
     * @return Un mensaje que indica si los datos son válidos o describe el error encontrado.
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

        if (nombresPaciente.length() > 100 || apellidoPaternoPaciente.length() > 50 || apellidoMaternoPaciente.length() > 50) {
            return "Los nombres y apellidos no deben exceder los 100 y 50 caracteres, respectivamente";
        }

        if (!nombresPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1 ]+") || !apellidoPaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+") || !apellidoMaternoPaciente.matches("[a-zA-ZÁ-Ýá-ý\u00f1\u00d1]+")) {
            return "Nombre en formato incorrecto, solo ingrese letras y un espacio entre los nombres";
        }

        if (calle.length() > 100 || colonia.length() > 50) {
            return "La calle y la colonia no deben exceder los 100 y 50 caracteres respectivamente";
        }
        return "validos";
    }
    /**
     * Actualiza la información de un paciente en la base de datos.
     * 
     * @param pacienteDTO Objeto DTO con los nuevos datos del paciente.
     * @return true si el paciente se actualizó correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre algún error en la validación o la persistencia.
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
     * Obtiene el ID de la dirección asociada a un paciente.
     * 
     * @param idPaciente El ID del paciente cuyo ID de dirección se desea obtener.
     * @return El ID de la dirección asociada al paciente.
     * @throws NegocioException Si ocurre un error al consultar la base de datos.
     */
    public int obtenerIdDireccionPorPaciente(int idPaciente) throws NegocioException {
        try {
            return pacienteDAO.obtenerIdDireccionPorPaciente(idPaciente);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el ID de la dirección: " + e.getMessage());
        }
    }
    /**
     * Obtiene los datos de un paciente dado su ID.
     * 
     * @param idPaciente El ID del paciente cuyos datos se desean obtener.
     * @return Un objeto PacienteActualizarDTO con los datos del paciente.
     * @throws NegocioException Si el paciente no existe o si ocurre un error al consultar la base de datos.
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
