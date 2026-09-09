class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i<n; i++){
            if(i+1 < n && value(s.charAt(i)) < value(s.charAt(i+1))){
                ans -= value(s.charAt(i));
            }
            else{
                ans += value(s.charAt(i));
            }
        }
        return ans;
    }

    private int value(char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
    }
}