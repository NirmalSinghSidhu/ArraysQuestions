import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfTwoArrays {

    // Approach 1: Using additional data structures like sets or maps
    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        for (int num : arr1) {
            union.add(num);
        }
        for (int num : arr2) {
            union.add(num);
        }
        return new ArrayList<>(union);
    }

    // Approach 2: Using merge operation similar to merge sort
    public static List<Integer> findUnion2(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } else {
                union.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            union.add(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            union.add(arr2[j]);
            j++;
        }
        return union;
    }


    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {4,5,6,7,8};

        List<Integer> ans = findUnion2(arr1,arr2);
        System.out.println(ans.toString());
    }
}
