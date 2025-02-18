package conexion;

import excepciones.PersistenciaException;
import java.sql.Connection;

/**
 * Interfaz que define el contrato para la conexión a la base de datos.
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 */
public interface IConexion {

    /**
     * Crea y devuelve una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws PersistenciaException si ocurre un error al establecer la
     * conexión.
     */
    public Connection crearConexion() throws PersistenciaException;

}
