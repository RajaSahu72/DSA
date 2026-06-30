class Solution {
    public int myAtoi(String s) {

        // Remove white spaces
        s = s.trim();

        long num = 0;
        int n = s.length();
        
        if(s.length() == 0){
            return 0;
        }


        int i = 0;
        int sign = 1;

        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            num = (num*10) + digit;

            if(num*sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

            if(num*sign >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int)(num*sign);
    }
}