import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            
            // Check for collisions: current asteroid is negative (moving left) 
            // and stack has positive asteroids (moving right)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int rightMoving = stack.peek();
                int leftMoving = Math.abs(asteroid);
                
                // If the left-moving asteroid is larger, pop the right-moving one
                if (leftMoving > rightMoving) {
                    stack.pop();
                    // Continue checking with the next asteroid in stack
                } 
                // If they are equal, both explode
                else if (leftMoving == rightMoving) {
                    stack.pop();
                    exploded = true;
                    break;
                } 
                // If right-moving asteroid is larger, current asteroid explodes
                else {
                    exploded = true;
                    break;
                }
            }
            
            // If current asteroid didn't explode, push it onto stack
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}