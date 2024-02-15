package Lists;

public class MyCatList {
    private Cat[] array;
    private int size;
    private int capacity;

    public MyCatList() {
        capacity = 5;
        size = 0;
        array = new Cat[capacity];
    }

    public void add(Cat num) throws ArrayFullException {
        try {
            array[size] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num.name);
        }
    }

    public void addAt(int pos, Cat num) throws ArrayFullException {
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
            throw new ArrayFullException(num.name);
        }
    }

    public boolean remove(String num) {
        for (int i=0; i < size; i++) {
            if (num == array[i].name) {
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public Cat removeAt(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        Cat ans = array[pos-1];
        for (int i = pos-1; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return ans;
    }

    public boolean contains(String num) {
        for(Cat i : array) {
            if (i != null && num == i.name) {
                return true;
            }
        }
        return false;
    }

    public Cat get(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        return array[pos-1];
    }

    public Cat set(int pos, Cat num) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        Cat orig = array[pos-1];
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
