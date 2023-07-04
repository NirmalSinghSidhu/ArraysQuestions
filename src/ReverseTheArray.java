import java.util.Arrays;

public class ReverseTheArray {
    // Approach 1: Using an additional array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed[j] = arr[i];
            j++;
        }
        return reversed;
    }

    // Approach 2: In-place reversal using two pointers
    public static void reverseArrayInPlace(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Approach recursive
    static void reverseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};

        reverseArrayInPlace(arr);
//        arr = reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
