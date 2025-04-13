import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        Node node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;
            Node newNode = new Node(item);
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException();
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException();
        removeNode(tail);
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        Object[] array = toArray();
        // Sort the array
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (((T) array[j]).compareTo((T) array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        // Rebuild linked list
        Node current = head;
        for (Object obj : array) {
            current.data = (T) obj;
            current = current.next;
        }
    }

    @Override
    public int indexOf(Object object) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}