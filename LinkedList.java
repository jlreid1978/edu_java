public class LinkedList<E> {
    private Node<E> head;
    private int size;

    
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Constructor
    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(E value) {
        add(size, value); // Just call add(int, E)
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if (index == 0) {
            head = new Node<>(value, head);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(value, prev.next);
        }
        size++;
    }

    public boolean contains(Object o) {
        for (Node<E> curr = head; curr != null; curr = curr.next) {
            if (o == null ? curr.data == null : o.equals(curr.data)) {
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public int indexOf(Object o) {
        int i = 0;
        for (Node<E> curr = head; curr != null; curr = curr.next, i++) {
            if (o == null ? curr.data == null : o.equals(curr.data)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        E removed;
        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            Node<E> prev = getNode(index - 1);
            removed = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    public boolean remove(Object o) {
        if (head == null) return false;

        if (o == null ? head.data == null : o.equals(head.data)) {
            head = head.next;
            size--;
            return true;
        }

        for (Node<E> curr = head; curr.next != null; curr = curr.next) {
            if (o == null ? curr.next.data == null : o.equals(curr.next.data)) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public E set(int index, E value) {
        Node<E> node = getNode(index);
        E old = node.data;
        node.data = value;
        return old;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(String.valueOf(curr.data));
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedList)) return false;

        LinkedList<?> other = (LinkedList<?>) obj;
        if (this.size != other.size) return false;

        Node<E> curr1 = this.head;
        Node<?> curr2 = other.head;

        while (curr1 != null && curr2 != null) {
            if (curr1.data == null ? curr2.data != null : !curr1.data.equals(curr2.data)) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }

    // Helper method to get node at specific index
    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
