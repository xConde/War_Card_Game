package Game;

/**
 * GameException. GameException extends RuntimeException.
 */
public class GameException extends RuntimeException {

    /**
     * Overloaded GameException, takes in a message and sends it to superclass.
     *
     * @param message
     */
    public GameException(String message) {
        super(message);
    }

    /**
     * Overloaded GameException, takes in a message and InterruptedException and sends them to a super class.
     *
     * @param message
     * @param e
     */
    public GameException(String message, InterruptedException e) {
        super(message, e);
    }
}
