/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import Encriptado.Encriptador;
import Encriptado.IEncriptador;
import Mapper.PacienteMapper;
import Mapper.UsuarioMapper;
import conexion.IConexion;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelr
 */
public class PacienteBO {
    private IEncriptador encriptador = new Encriptador();
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
     * @param pacienteNuevo Objeto DTO que contiene la información del
     * paciente a agregar.
     * @return boolean Devuelve true si el paciente se agregó correctamente,
     * false en caso contrario.
     * @throws NegocioException Si hay problemas en las capas.
     */
    public boolean RegistrarPaciente(PacienteDTO pacienteNuevo) throws NegocioException {
        // Validar que el paciente no sea nulo.
        if (pacienteNuevo == null ) {
            System.out.println("Error: El paciente es nulo");
            return false;
        }
        // Verificar que los campos no esten vacios.
        if (pacienteNuevo.getNombresPaciente().isEmpty() || pacienteNuevo.getContrasenaUsuario().isEmpty() || pacienteNuevo.getApellidoPaternoPaciente().isEmpty() 
                || pacienteNuevo.getApellidoMaternoPaciente().isEmpty() || pacienteNuevo.getCorreo().isEmpty() || pacienteNuevo.getTelefono().isEmpty()
                || pacienteNuevo.getDireccion().toString().isEmpty() || pacienteNuevo.getFechaNacimiento().toString().isEmpty()) {
            throw new NegocioException("Error: Campos Vacios");
        }
        // Uso de Mapper para convertir a Entidad y Encriptación de contraseña.
        Paciente paciente = mapperPaciente.ConvertirAEntidad(pacienteNuevo);
        String contrasenaEncriptada = encriptador.encriptar(pacienteNuevo.getContrasenaUsuario());
        paciente.setContrasenaUsuario(contrasenaEncriptada);
        // Registrar
        try {
            Paciente pacienteAGuardar = pacienteDAO.registrarPaciente(paciente);
            return pacienteAGuardar != null;
        } catch(PersistenciaException pe){
            // Registro de error con el logger
            logger.log(Level.SEVERE, "Error: error al guardar paciente en la base de datos", pe);
            // Muestra excepcion con un mensaje
            throw new NegocioException("Error: No se pudo registrar el paciente");
        }
    }

}
