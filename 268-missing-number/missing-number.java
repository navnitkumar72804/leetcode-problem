class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int actualsum=0;
        int Nsum=n*(n+1)/2;
        for(int i=0;i<n;i++){
            actualsum+=nums[i];
        }
        return Nsum-actualsum;
    }
}