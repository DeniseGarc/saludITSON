/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IPacienteDAO;
import DAO.IUsuarioDAO;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import DTO.PacienteNuevoDTO;
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
     * a agregar.
     * @return boolean Devuelve true si el paciente se agregó correctamente,
     * false en caso contrario.
     * @throws NegocioException Si hay problemas en las capas.
     */
    public boolean registrarPaciente(PacienteNuevoDTO pacienteNuevo) throws NegocioException {
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
     * Metodo que valida los datos del paciente, si uno de los datos introducidos no cumple con los 
     * requerimientos, devuelve el error correspondiente.
     * @param paciente
     * @return 
     */
    private String validarDatosPaciente(PacienteNuevoDTO paciente) {
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
        if (!nombresPaciente.matches("[a-zA-Z ]+") || !apellidoPaternoPaciente.matches("[a-zA-Z]+") || !apellidoMaternoPaciente.matches("[a-zA-Z]+")) {
            return "Nombre en formato incorrecto, puede ingresar sus nombres pero solo ingrese un apellido por campo";
        }

        return "validos";
    }

    /*
    Metodo que se encarga de validar que el correo y la contraseña existen.
    Si si existen en la base de datos, el paciente se logea.
    Muestra un error correspondiente en caso contrario.
     */
    public int Login(String correo, String contrasena) throws NegocioException, PersistenciaException {
        try {

            // Validar que los campos no esten vacios.
            if (correo == null || contrasena == null) {
                throw new NegocioException("Error: El correo o la contraseña son incorrectos o no se encuentran registados");

            } else if (correo.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: Los campos estan vacios.");
                return 0;
            } else {
                int id = pacienteDAO.consultarIDPacientePorContrasenaCorreo(correo, contrasena);
                return id;
            }

        } catch (NegocioException pe) {
            // Registro de error con el logger
            logger.log(Level.SEVERE, "Error: error al obtener el ID en la base de datos", pe);
            // Muestra excepcion con un mensaje

            throw new NegocioException("Error al intentar registrar en el sistema.");

        }
    }
    

    public static boolean esCampoValido(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

}
