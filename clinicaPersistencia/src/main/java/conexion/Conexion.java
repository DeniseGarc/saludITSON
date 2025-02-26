package conexion;

import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que establece una conexión con la base de datos MySQL. Implementa la
 * interfaz IConexion para proporcionar una conexión a la base de datos.
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 */
public class Conexion implements IConexion {

    /**
     * URL de la base de datos.
     */
    final String URL = "jdbc:mysql://localhost:3306/clinicaprivada";
    /**
     * Usuario para la conexión a la base de datos.
     */
    final String USER = "root";
    /**
     * Contraseña para la conexión a la base de datos.
     */
    final String PASS = "itson";

    /**
     * Crea y devuelve una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws PersistenciaException si ocurre un error al establecer la
     * conexión.
     */
    @Override
    public Connection crearConexion() throws PersistenciaException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            return conexion;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error en conexion");
        }
    }
}
