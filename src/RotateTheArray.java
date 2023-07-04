import java.util.Arrays;

public class RotateTheArray {
    //cyclically rotate an array by one:

    // Approach 1: Using an additional array to store rotated elements
    public  static void rotateArray(int[] arr){
        int n = arr.length;
        int[] rotated = new int[n];
        rotated[0] = arr[n-1];
        for(int i = 0;i < n - 1;i++){
            rotated[i+1]=arr[i];
        }
        System.arraycopy(rotated,0,arr,0,n);
    }

    // Approach 2: Rotating elements in-place using a temporary variable
    public static void rotateArray2(int[] arr) {
        int n = arr.length;
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        rotateArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
