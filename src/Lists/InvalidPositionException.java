package Lists;

public class InvalidPositionException extends IllegalArgumentException {
    public InvalidPositionException(int upper) {
        super("Position must be between 1 and " + upper);
    }
}
