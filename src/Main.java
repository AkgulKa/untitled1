public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);
        System.out.println("ArrayList before sort: ");
        for (int i : arrayList) System.out.print(i + " ");
        arrayList.sort();
        System.out.println("\nArrayList after sort: ");
        for (int i : arrayList) System.out.print(i + " ");
        System.out.println();

        // Test MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("B");
        linkedList.addFirst("A");
        linkedList.addLast("C");
        System.out.println("LinkedList: ");
        for (String s : linkedList) System.out.print(s + " ");
        System.out.println();

        // Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop()); // 3
        System.out.println("Stack peek: " + stack.peek()); // 2

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue dequeue: " + queue.dequeue()); // A
        System.out.println("Queue peek: " + queue.peek()); // B

        // Test MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        System.out.println("MinHeap extractMin: " + minHeap.extractMin()); // 1
        System.out.println("MinHeap peek: " + minHeap.peek()); // 3
    }
}