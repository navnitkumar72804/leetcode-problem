import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Max heap to always pick the task with highest frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }
        
        int intervals = 0;
        
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // Number of tasks we can process in one cycle
            
            // Process up to (n+1) tasks in this cycle
            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    if (count > 1) {
                        temp.add(count - 1);
                    }
                }
                intervals++;
                
                // If heap is empty and no more tasks to process, break
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            
            // Add back remaining tasks to heap
            for (int count : temp) {
                maxHeap.offer(count);
            }
        }
        
        return intervals;
    }
}