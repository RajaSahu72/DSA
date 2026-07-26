class Solution {
    public double myPow(double x, int n) {
        long binForm = n;
        double ans = 1;

        // For -ve power
        if(binForm < 0){
            x = 1/x;
            binForm = -binForm;
        }

        // Binary Exponention
        while(binForm > 0){
            if(binForm%2 == 1){
                ans = ans * x;
            }
            x *= x;
            binForm /= 2;
        }

        return ans;
    }
}
