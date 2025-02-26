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
     * Este método crea una nueva instancia de la clase PacienteBO, 
     * inyectando una dependencia de tipo IConexion a través de la creación 
     * de una nueva instancia de `Conexion`.
     * 
     * @return La instancia de PacienteBO creada.
     */
    public static PacienteBO crearPacienteBO() {
        // Crea la conexión
        IConexion conexion = new Conexion();
        // Crea y devuelve la instancia de PacienteBO
        PacienteBO pacienteBO = new PacienteBO(conexion);
        return pacienteBO;
    }

    /**
     * Crea una instancia de UsuarioBO.
     * 
     * Este método crea una nueva instancia de la clase UsuarioBO, 
     * inyectando una dependencia de tipo IConexion a través de la creación 
     * de una nueva instancia de Conexion.
     * 
     * @return La instancia de UsuarioBO creada.
     */
    public static UsuarioBO crearUsuarioBO() {
        IConexion conexion = new Conexion();
        UsuarioBO usuarioBO = new UsuarioBO(conexion);
        return usuarioBO;
    }

    /**
     * Crea una instancia de MedicoBO.
     * 
     * Este método crea una nueva instancia de la clase MedicoBO, 
     * inyectando una dependencia de tipo IConexion a través de la creación 
     * de una nueva instancia de Conexion.
     * 
     * @return La instancia de MedicoBO creada.
     */
    public static MedicoBO crearMedicoBO() {
        IConexion conexion = new Conexion();
        MedicoBO medicoBO = new MedicoBO(conexion);
        return medicoBO;
    }

    /**
     * Crea una instancia de CitaBO.
     * 
     * Este método crea una nueva instancia de la clase CitaBO, 
     * inyectando una dependencia de tipo IConexion a través de la creación 
     * de una nueva instancia de Conexion.
     * 
     * @return La instancia de CitaBO creada.
     */
    public static CitaBO crearCitaBO() {
        IConexion conexion = new Conexion();
        CitaBO citaBO = new CitaBO(conexion);
        return citaBO;
    }
}

