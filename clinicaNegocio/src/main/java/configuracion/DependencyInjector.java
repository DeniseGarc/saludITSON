package configuracion;

import BO.MedicoBO;
import BO.CitaBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import conexion.Conexion;
import conexion.IConexion;

/**
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 */
public class DependencyInjector {
     /**
     * Crea una instancia de PacienteBO.
     * 
     * @return Un objeto de tipo PacienteBO configurado con la conexión.
     */
    public static PacienteBO crearPacienteBO() {
        IConexion conexion = new Conexion();
        PacienteBO pacienteBO = new PacienteBO(conexion);
        return pacienteBO;
    }   
    /**
     * Crea una instancia de UsuarioBO.
     * 
     * @return Un objeto de tipo UsuarioBO configurado con la conexión.
     */
    public static UsuarioBO crearUsuarioBO(){
        IConexion conexion = new Conexion();
        UsuarioBO usuarioBO = new UsuarioBO(conexion);
        return usuarioBO;
    }
    /**
     * Crea una instancia de MedicoBO.
     * 
     * @return Un objeto de tipo MedicoBO configurado con la conexión.
     */
    public static MedicoBO crearMedicoBO(){
        IConexion conexion = new Conexion();
        MedicoBO medicoBO = new MedicoBO(conexion);
        return medicoBO;
    }
    /**
     * Crea una instancia de CitaBO.
     * 
     * @return Un objeto de tipo CitaBO configurado con la conexión.
     */
    public static CitaBO crearCitaBO() {
        IConexion conexion = new Conexion();
        CitaBO citaBO = new CitaBO(conexion);

        return citaBO;
    }
}
