package configuracion;

import BO.CitaBO;
import BO.PacienteBO;
import conexion.Conexion;
import conexion.IConexion;

/**
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 */
public class DependencyInjector {

    public static PacienteBO crearPacienteBO() {
        IConexion conexion = new Conexion();
        PacienteBO pacienteBO = new PacienteBO(conexion);

        return pacienteBO;
    }

    public static CitaBO crearCitaBO() {
        IConexion conexion = new Conexion();
        CitaBO citaBO = new CitaBO(conexion);

        return citaBO;
    }
}
