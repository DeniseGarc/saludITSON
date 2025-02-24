package configuracion;

import BO.MedicoBO;
import BO.PacienteBO;
import BO.UsuarioBO;
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
    public static UsuarioBO crearUsuarioBO(){
        IConexion conexion = new Conexion();
        UsuarioBO usuarioBO = new UsuarioBO(conexion);
        return usuarioBO;
    }
    public static MedicoBO crearMedicoBO(){
        IConexion conexion = new Conexion();
        MedicoBO medicoBO = new MedicoBO(conexion);
        return medicoBO;
    }
}
