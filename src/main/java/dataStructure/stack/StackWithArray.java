package dataStructure.stack;

class StackWithArray {
    private int arr[];
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    StackWithArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // Utility function to pop a top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }

    // Utility function to return the top element of the stack
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(-1);
        }

        return -1;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1;               // or return size() == 0;
    }

    // Utility function to check if the stack is full or not
    public boolean isFull() {
        return top == size();     // or return size() == capacity;
    }
}