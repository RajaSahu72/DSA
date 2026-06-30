class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while(col >= 0 && row < matrix.length){
            if(matrix[row][col] == target){
                return true;
            }
            else if(target < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }

        return false;
    }
}