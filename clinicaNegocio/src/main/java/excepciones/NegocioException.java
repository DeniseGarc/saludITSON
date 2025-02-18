package excepciones;

/**
 * Excepción personalizada para errores de lógica de negocio en la aplicación.
 *
 * @author Joel Borbon, Alicia Garcia, benjamin soto
 *
 */
public class NegocioException extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message Mensaje descriptivo del error.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa del error.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause Causa original del error.
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
