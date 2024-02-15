package Lists;

public class MyList {
    private int[] array;
    private int size;
    private int capacity;

    public MyList() {
        capacity = 5;
        size = 0;
        array = new int[capacity];
    }

    public void add(int num) throws ArrayFullException {
        try {
            array[size] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num+"");
        }
    }

    public void addAt(int pos, int num) throws ArrayFullException {
        if (pos > size + 1 || pos <= 0) {
            throw new InvalidPositionException(size+1);
        }
        try {
            for (int i = size; i >= pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos-1] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num+"");
        }
    }

    public boolean remove(int num) {
        for (int i=0; i < size; i++) {
            if (num == array[i]) {
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int removeAt(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        int ans = array[pos-1];
        for (int i = pos-1; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return ans;
    }

    public boolean contains(int num) {
        for(int i : array) {
            if (num == i) {
                return true;
            }
        }
        return false;
    }

    public int get(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        return array[pos-1];
    }

    public int set(int pos, int num) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        int orig = array[pos-1];
        array[pos-1] = num;
        return orig;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
