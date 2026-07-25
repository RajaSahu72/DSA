class Solution {
    public double myPow(double x, int n) {
        long N = n;

        // For -ve power
        if(N < 0){
            x = 1/x;
            N = -N;
        }

        return power(x,N);
    }

    private double power(double x, long n){
        if(n == 0){
            return 1;
        }

        double halfPower = power(x,n/2);
        double halfPowerSq = halfPower * halfPower;

        if(n%2 != 0){
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }
}