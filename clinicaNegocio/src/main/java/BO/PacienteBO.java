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

/**
 *
 * @author joelr
 */
public class PacienteBO {

    private final IEncriptador encriptador = new Encriptador();
    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    private final IPacienteDAO pacienteDAO;
    private final PacienteMapper mapperPaciente = new PacienteMapper();
    private final UsuarioMapper mapperUsuario = new UsuarioMapper();

    public PacienteBO(IConexion conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
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
        // Uso de Mapper para convertir a Entidad y Encriptación de contraseña.
        Paciente paciente = mapperPaciente.convertirAEntidad(pacienteNuevo);
        String contrasenaEncriptada = encriptador.encriptar(pacienteNuevo.getContrasenaUsuario());
        paciente.setContrasenaUsuario(contrasenaEncriptada);
        // Registrar
        try {
            Paciente pacienteAGuardar = pacienteDAO.registrarPaciente(paciente);
            return pacienteAGuardar != null;
        } catch (PersistenciaException pe) {
            // Registro de error con el logger
            logger.log(Level.SEVERE, "Error: error al guardar paciente en la base de datos", pe);
            // Muestra excepcion con un mensaje
            throw new NegocioException("Error al intentar registrar en el sistema.");
        }
    }

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
        if (!nombresPaciente.matches("[a-zA-Záéíóú ]+") || !apellidoPaternoPaciente.matches("[a-zA-Záéíóú]+") || !apellidoMaternoPaciente.matches("[a-zA-Z]+")) {
            return "Nombre en formato incorrecto, puede ingresar sus nombres pero solo ingrese un apellido por campo";
        }

        return "validos";
    }

    public static boolean esCampoValido(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public String obtenerNombreCompletoPaciente(int idPaciente) throws NegocioException {
        try {
            return pacienteDAO.consultarNombreCompletoPaciente(idPaciente);
        } catch (PersistenciaException e) {
            throw new NegocioException(null + e.getMessage(), e);
        }
    }

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

        if (!nombresPaciente.matches("[a-zA-Záéíóú ]+") || !apellidoPaternoPaciente.matches("[a-zA-Záéíóú]+") || !apellidoMaternoPaciente.matches("[a-zA-Z]+")) {
            return "Nombre en formato incorrecto, solo ingrese letras y un espacio entre los nombres";
        }

        if (calle.length() > 100 || colonia.length() > 50) {
            return "La calle y la colonia no deben exceder los 100 y 50 caracteres respectivamente";
        }
        return "validos";
    }

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

    public int obtenerIdDireccionPorPaciente(int idPaciente) throws NegocioException {
        try {
            return pacienteDAO.obtenerIdDireccionPorPaciente(idPaciente);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el ID de la dirección: " + e.getMessage());
        }
    }

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
