class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort based on squared distance (avoid sqrt for efficiency)
        Arrays.sort(points, (a, b) -> 
            (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
        );
        
        // Return first k points
        return Arrays.copyOfRange(points, 0, k);
    }
}