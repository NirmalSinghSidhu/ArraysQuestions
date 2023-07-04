public class InversionCount {
    /*
    Inversion Count for an array indicates – how far (or close) the array is from being sorted.
    If the array is already sorted, then the inversion count is 0,
    but if the array is sorted in reverse order, the inversion count is the maximum.

   Given an array arr[]. The task is to find the inversion count of arr[].
   Where two elements arr[i] and arr[j] form an inversion if a[i] > a[j] and i < j.

    Examples:

   Input: arr[] = {8, 4, 2, 1}
   Output: 6
   Explanation:
   Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
     */

    //Approach 1 for loops
    public static int inversionCount(int[] arr){
        int inCnt =0;
        for(int i = 0; i< arr.length-1;i++){
            for(int j = i + 1; j< arr.length;j++){
                if(arr[j]<arr[i]){
                    inCnt++;
                }
            }
        }
        return inCnt;
    }

    //mergeSort Approach
    public static int countInversion2(int[] arr){
        return mergeSort(arr,0, arr.length-1);
    }
    private static int mergeSort(int[] arr,int left ,int right){
        int count  = 0;
        if(left<right){
            int mid = left + (right -left)/2;
            count += mergeSort(arr,left,mid);
            count += mergeSort(arr,mid+1,right);
            count += merge(arr,left,mid,right);
        }
        return count;
    }
    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 20, 6, 4, 5 };

        System.out.println(inversionCount(arr));
    }
}
