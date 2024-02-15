package Lists;

public class ArrayFullException extends Exception {
    public ArrayFullException(Object num) {
        super("The array is full and " + num + " cannot be inserted.");
    }
}
