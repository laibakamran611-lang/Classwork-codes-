package dsaaignment;

public class StackLinkedListt {
    private Node top;

    // ================= Node =================
    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // ================= Stack Operations =================
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to stack");
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        Node current = top;
        System.out.print("Stack elements: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printStack2() {
        System.out.println("Printing and emptying stack:");
        while(!isEmpty()) {
            System.out.println(pop());
        }
    }

    // ================= Main Method =================
    public static void main(String[] args) {
        StackLinkedListt stack = new StackLinkedListt();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Print
        stack.printStack(); // 30 20 10

        // Peek
        System.out.println("Top element: " + stack.peek());

        // Pop
        System.out.println("Popped: " + stack.pop());

        // Print again
        stack.printStack(); // 20 10

        // Empty stack
        stack.printStack2(); // prints and empties

        // Check empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
