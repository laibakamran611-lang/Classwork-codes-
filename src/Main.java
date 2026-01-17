// ================= QUEUE USING ARRAY =================
class QueueArray {
    private int[] arr;
    private int size;
    private int rear;
    private int front;

    public QueueArray(int capacity) {
        arr = new int[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[++rear] = value;
        size++;
        System.out.println(value + " enqueued (Array)");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = arr[front];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        size--;
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Queue resized");
    }

    public void printQueue() {
        System.out.print("Array Queue: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// ================= QUEUE USING LINKED LIST =================
class QueueLinkedList {
    private Node front, rear;

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued (LinkedList)");
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = front.data;
        front = front.next;
        if (front == null) rear = null;
        return removed;
    }

    public void printQueue() {
        System.out.print("LinkedList Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// ===================== MAIN CLASS (ONLY ONE) =====================
public class Main {
    public static void main(String[] args) {

        // Queue using Array
        QueueArray qa = new QueueArray(5);
        qa.enqueue(5);
        qa.enqueue(6);
        qa.enqueue(7);
        qa.printQueue();
        qa.dequeue();
        qa.printQueue();

        System.out.println();

        // Queue using Linked List
        QueueLinkedList ql = new QueueLinkedList();
        ql.enqueue(10);
        ql.enqueue(20);
        ql.enqueue(30);
        ql.printQueue();
        ql.dequeue();
        ql.printQueue();
    }
}
