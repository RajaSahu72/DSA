class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int openBrackets = 0;

        for(Character ch : s.toCharArray()){
            if(ch == '('){
                openBrackets++;
            }
            if(ch == ')'){
                openBrackets--;
            }

            ans = Math.max(ans, openBrackets);
        }

        return ans;
    }
}