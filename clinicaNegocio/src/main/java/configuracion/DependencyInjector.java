package configuracion;

import BO.PacienteBO;
import conexion.Conexion;
import conexion.IConexion;

/**
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 */
public class DependencyInjector {
    public static PacienteBO crearPacienteBO(){
        IConexion conexion = new Conexion();
        PacienteBO pacienteBO = new PacienteBO(conexion);
        
        return pacienteBO;
    }
}
