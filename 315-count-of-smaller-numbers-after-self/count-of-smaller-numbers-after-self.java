class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n];
        
        // Initialize indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Use iterative merge sort with temporary arrays for speed
        int[] tempIndices = new int[n];
        mergeSort(nums, indices, result, tempIndices, 0, n - 1);
        
        List<Integer> resultList = new ArrayList<>(n);
        for (int count : result) {
            resultList.add(count);
        }
        return resultList;
    }
    
    private void mergeSort(int[] nums, int[] indices, int[] result, int[] tempIndices, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, result, tempIndices, left, mid);
        mergeSort(nums, indices, result, tempIndices, mid + 1, right);
        
        // Merge
        int i = left, j = mid + 1, k = left;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                result[indices[i]] += rightCount;
                tempIndices[k++] = indices[i++];
            } else {
                rightCount++;
                tempIndices[k++] = indices[j++];
            }
        }
        
        while (i <= mid) {
            result[indices[i]] += rightCount;
            tempIndices[k++] = indices[i++];
        }
        
        while (j <= right) {
            tempIndices[k++] = indices[j++];
        }
        
        // Copy back
        System.arraycopy(tempIndices, left, indices, left, right - left + 1);
    }
}