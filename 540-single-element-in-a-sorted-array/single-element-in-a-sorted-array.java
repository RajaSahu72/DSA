class Solution {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;

        if(n == 1) return A[0];

        int st = 0;
        int end = n-1;

        while(st <= end){
            int mid = st + (end - st)/2;

            if(mid == 0 && A[0] != A[1]) return A[0]; //mid in 0th idx
            if(mid == n-1 && A[n-1] != A[n-2]) return A[n-1]; //mid in n-1 th idx

            if(A[mid-1] != A[mid] && A[mid] != A[mid+1]) return A[mid];
            
            // Even
            if(mid%2 == 0){
                if(A[mid-1] == A[mid]){
                    end = mid-1;
                }
                else{
                    st = mid+1;
                }
            }
            else{ // Odd
                if(A[mid-1] == A[mid]){
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}