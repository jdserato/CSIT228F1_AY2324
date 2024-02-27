package Feb27;

public class ThreadSafeCounter {
    private int count;
    synchronized public void increment() {
        count = count + 1;
    }
    synchronized public int getCount() {
        return count;
    }
    synchronized public void reset() {
        count = 0;
    }
}
