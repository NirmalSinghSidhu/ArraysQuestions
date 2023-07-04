import java.util.Arrays;

public class Sort012 {

    // Approach 1: Counting the occurrences of 0, 1, and 2 and reconstructing the array
    public static void sortArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            }
        }
        int i = 0;
        while (count0 > 0) {
            arr[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            arr[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            arr[i++] = 2;
            count2--;
        }
    }

    // Approach 2: Dutch National Flag Algorithm (three-way partitioning)
    public static void sortArrayDNF(int[] arr){
        int zero = 0 , one = 0, two = arr.length-1;

        while(one<=two){
            if(arr[one] == 0){
                swap(arr,zero,one);
                zero++;
                one++;
            } else if (arr[one] == 1) {
                one++;
            } else if (arr[one] == 2) {
                swap(arr,one,two);
                two--;
            }
        }
    }



    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int arr[] = {1,1,1,0,2,2,0,0,2};

        sortArrayDNF(arr);

        System.out.println(Arrays.toString(arr));
    }
}
