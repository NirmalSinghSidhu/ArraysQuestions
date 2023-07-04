import java.util.Arrays;

public class mergeTwoSortedArray {

    // Approach 1: Using two pointers to merge the arrays in-place
    public static void mergeArrays(int[] arr1 , int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int i = m -1;
        int j =0;

        while(i>=0 && j < n){
            if(arr1[i]>arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            }else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Approach 2: Using the Merge operation similar to merge sort
    public static void mergeArrays2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, k = m - 1;
        while (i <= k && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    public static void main(String[] args) {
     int[] arr1 = {1,4,5,12,23};
     int[] arr2 = {6,8,15,56};

     mergeArrays(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
