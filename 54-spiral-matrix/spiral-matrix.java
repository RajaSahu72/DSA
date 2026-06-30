class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int sRow = 0;
        int eRow = matrix.length-1;
        int sCol = 0;
        int eCol = matrix[0].length-1;

        while(sRow <= eRow && sCol <= eCol){
            //Top
            for(int j = sCol; j<=eCol; j++){
                ans.add(matrix[sRow][j]);
            }

            //Right
            for(int i = sRow+1; i<=eRow; i++){
                ans.add(matrix[i][eCol]);
            }

            //Bottom
            for(int j = eCol-1; j>=sCol; j--){
                if(sRow == eRow){
                    break;
                }
                ans.add(matrix[eRow][j]);
            }

            //Left
            for(int i = eRow-1; i>=sRow+1; i--){
                if(sCol == eCol){
                    break;
                }
                ans.add(matrix[i][sCol]);
            }

            sRow++;
            eRow--;
            sCol++;
            eCol--;
        }

        return ans;
    }

}
