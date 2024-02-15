package Feb06;

public class BadAgeException extends Exception{
    public BadAgeException() {
        super("Cats cannot be predicted into the future");
    }

    public BadAgeException(String message) {
        super(message);
    }
}
