class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // Fill the rest with zeros
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
