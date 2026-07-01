class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCase = 0;
        // Count the number of upperCase
        for(int i = 0; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))){
                upperCase++;
            }
        }

        if( (upperCase == word.length()) || (upperCase == 0) || (upperCase == 1 && Character.isUpperCase(word.charAt(0))) ){
            return true;
        }
        else{
            return false;
        }
    }
}