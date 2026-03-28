import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        
        // Push elements in the order given by pushed array
        for (int value : pushed) {
            stack.push(value);
            
            // While stack is not empty and top matches the next popped element
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        // If we've popped all elements, the sequence is valid
        return stack.isEmpty();
    }
}