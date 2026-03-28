import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create buckets (index = frequency)
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Step 3: Add elements to buckets based on frequency
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int frequency = entry.getValue();
            buckets[frequency].add(entry.getKey());
        }
        
        // Step 4: Collect top k frequent elements
        int[] result = new int[k];
        int resultIndex = 0;
        
        for (int i = buckets.length - 1; i >= 0 && resultIndex < k; i--) {
            for (int num : buckets[i]) {
                result[resultIndex++] = num;
                if (resultIndex == k) {
                    break;
                }
            }
        }
        
        return result;
    }
}