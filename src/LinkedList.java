public class LinkedList<E> {
    Node<E> head, tail;
    int size;

    void add(E num) {
        Node<E> n = new Node<>(num);
        if (tail != null) {
            tail.next = n;
        } else {
            head = n;
        }
        tail = n;
        size++;
    }

    E set(E num, int pos) {
        if (pos <= 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        Node<E> curr = head;
        for (int ctr = 1; ctr < pos; ctr++) {
            curr = curr.next;
        }
        E orig = curr.elem;
        curr.elem = num;
        return orig;
    }

    void print() {
        Node<E> curr = head;
        while (curr != null) {
            System.out.print(curr.elem + " -> ");
            curr = curr.next;
        }
    }
}
