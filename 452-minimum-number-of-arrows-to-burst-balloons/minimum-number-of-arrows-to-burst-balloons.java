import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Sort balloons by their ending coordinate
        Arrays.sort(points, (a, b) -> {
            // Use Integer.compare to avoid integer overflow
            return Integer.compare(a[1], b[1]);
        });
        
        int arrows = 1;
        int currentEnd = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (currentEnd < points[i][0]) {
                // Current arrow can't burst this balloon, need a new arrow
                arrows++;
                currentEnd = points[i][1];
            }
            // Else: Current arrow can burst this balloon (overlap), no new arrow needed
        }
        
        return arrows;
    }
}