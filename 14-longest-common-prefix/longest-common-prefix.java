class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        // Step 1 - Create a String Builder result for common prefix
        StringBuilder result = new StringBuilder();

        // Step 2 - sort string alphabetically
        Arrays.sort(strs);

        // Step 3 - Compare only first and last strings
        char[] first = strs[0].toCharArray();
        char[] last = strs[n-1].toCharArray();

        // Step 4 - Check character from left to right
        for(int i = 0; i<first.length && i<last.length; i++){
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }

        return result.toString();
    }
}