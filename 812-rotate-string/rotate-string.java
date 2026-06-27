class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        String str = s + s;

        //Check that goal is exist in the str
        if(str.contains(goal)){
            return true;
        }
        else{
            return false;
        }
    }
}