import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        // Always push to input stack
        inputStack.push(x);
    }
    
    public int pop() {
        // Ensure output stack has the front element
        transferIfNeeded();
        // Pop from output stack (front of queue)
        return outputStack.pop();
    }
    
    public int peek() {
        // Ensure output stack has the front element
        transferIfNeeded();
        // Peek at output stack (front of queue)
        return outputStack.peek();
    }
    
    public boolean empty() {
        // Queue is empty if both stacks are empty
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    private void transferIfNeeded() {
        // If output stack is empty, transfer all elements from input stack
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */