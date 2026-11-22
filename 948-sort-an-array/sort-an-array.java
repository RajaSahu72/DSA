class Solution {
    public int[] sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    private void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    }

    private void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid){
           temp[k] = arr[i];
            i++;
            k++; 
        }

        while(j <= ei){
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(k = 0, i = si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
}