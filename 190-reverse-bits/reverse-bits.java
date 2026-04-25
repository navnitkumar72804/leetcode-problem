public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // Get the last bit of n
            int lastBit = n & 1;
            
            // Shift result left to make room for the new bit
            result = (result << 1) | lastBit;
            
            // Shift n right to process the next bit
            n = n >> 1;
        }
        
        return result;
    }
}