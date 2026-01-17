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

    // Enqueue
    public void enqueue(int value) {
        if (size == arr.length) {
            resize();
        }
        rear++;
        arr[rear] = value;
        size++;
        System.out.println(value + " enqueued");
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = arr[front];

        // shift elements
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        size--;
        return removed;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize array
    private void resize() {
        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        System.out.println("Queue resized to " + newSize);
    }

    // Print queue
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// ===================== MAIN CLASS =====================
public class Main {
    public static void main(String[] args) {

        QueueArray queue = new QueueArray(5);

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}
