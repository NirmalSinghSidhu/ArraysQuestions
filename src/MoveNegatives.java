import java.util.Arrays;

public class MoveNegatives {

    // Approach 1: Using two pointers to swap negative elements to the left side
    public static void moveNegativesToLeft(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            if(arr[left] < 0 && arr[right] > 0){
                left++;
                right--;
            }
            else if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] >= 0 && arr[right] < 0) {
               swap(arr,left,right);
                left++;
                right--;
            }else{
               right--;
            }
        }
    }
    // Approach 2: Using the partitioning algorithm similar to quicksort
    public static void moveNegativesToLeft2(int[] arr) {
        int pivot = 0;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
    }

    //two pointer

    public static void moveNegativesToRight(int[] arr){
        int left =0;
        int right = arr.length-1;

        while(left <= right){
            if(arr[left] > 0 && arr[right] < 0){
                left++;
                right--;
            }
            else if (arr[left] > 0 && arr[right] > 0) {
                left++;
            } else if (arr[left] < 0 && arr[right] >= 0) {
                swap(arr,left,right);
                left++;
                right--;
            }else{
                right--;
            }
        }
    }

    // Approach 2

    public static void moveNegativesToRight2(int[] arr){
        int pivot = 0;
        int j = 0;
        for(int i =0 ;i< arr.length;i++){
            if(arr[i] >= 0){
                swap(arr,j,i);
                j++;
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 1,2,-3,-4,2,-31,8,0,-1};
        moveNegativesToLeft(arr);
        System.out.println(Arrays.toString(arr));
        moveNegativesToRight2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
