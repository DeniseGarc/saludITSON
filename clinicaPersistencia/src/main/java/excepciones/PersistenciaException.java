package excepciones;

/**
 * Excepción personalizada para errores de persistencia en la aplicación.
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 *
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message Mensaje descriptivo del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa del error.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause Causa original del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
