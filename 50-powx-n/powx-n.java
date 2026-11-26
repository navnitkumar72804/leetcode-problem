
class Solution {

    public double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            return 1.0 / calculate(x, -power);
        }

        return calculate(x, power);
    }

    public double calculate(double x, long n) {

       
        if (n == 0) {
            return 1.0;
        }

        
        double half = calculate(x, n / 2);

        
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}
