package Game;

public class GameException extends RuntimeException {

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, InterruptedException e) {
        super(message, e);
    }
}
