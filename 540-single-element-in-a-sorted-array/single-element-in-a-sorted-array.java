class Solution {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;

        if(n == 1) return A[0];
        
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid == 0 && A[0] != A[1]) return A[0];
            if(mid == n-1 && A[n-1] != A[n-2]) return A[n-1];
            
            if(A[mid-1] != A[mid] && A[mid] != A[mid+1]){
                return A[mid];
            }

            if(mid%2 == 0){
                if(A[mid-1] == A[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(A[mid-1] == A[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}