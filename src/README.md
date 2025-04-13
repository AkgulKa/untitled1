# Custom Data Structures in Java

This project implements custom data structures in Java without using `java.util.*` collections, except `Iterator`.

## Implemented Classes

###  Data Structures
- **MyArrayList<T>** — Custom ArrayList
- **MyLinkedList<T>** — Custom Doubly LinkedList

### Logical Data Structures
- **MyStack<T>** — Stack (based on MyArrayList)
- **MyQueue<T>** — Queue (based on MyLinkedList)
- **MyMinHeap<i T>** — MinHeap for priority operations (based on MyArrayList)

## Features

- Add, remove, and retrieve elements by index
- Access first and last elements
- Sort elements (Bubble Sort for simplicity)
- Check existence of elements
- Support for custom iterator
- Stack operations: push, pop, peek
- Queue operations: enqueue, dequeue, peek
- MinHeap operations: insert, extractMin, peek
- Manual capacity handling and resizing for array structures
- Prevent loops in linked list

## MyArrayList
- add(item) — Add to end
- add(index, item) — Add at index
- addFirst(item) — Add to start
- addLast(item) — Add to end
- indexOf(object) — First index of object
- exists(object) — Check existence
-	size() — Number of elements
-	clear() — Clear all elements
 ## MyQueue
  - enqueue(item) — Add to end
  - dequeue() — Remove from front
  -  peek() — View front element
  - isEmpty() — Check if empty
  - size() — Queue size
## MyMinHeap
- insert(item) — Add and heapify
 - extractMin() — Remove smallest
 - peek() — View smallest
-  isEmpty() — Check if empty
- size() — Heap size
## MyLinkedList
- remove(index) — Remove by index
- removeFirst() — Remove first element
- add(item) — Add to end
-  addFirst(item) — Add to start
-    addLast(item) — Add to end
-    get(index) — Get element
## Usage

Run `Main.java` to test all methods.
If you want to compile and run manually via terminal: ```bash  --javac *.java--java Main

##Project Guidelines
- No use of `java.util.*` (except `Iterator`)
- Generics with type-safe comparisons
- Fully tested with multiple cases
- Documented code with comments
-  Clean commit history 