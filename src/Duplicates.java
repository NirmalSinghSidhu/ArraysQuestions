import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    /*
    Given an array of integers nums containing n + 1 integers
    where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums,
    return this repeated number.

    Input: nums = [1,3,4,2,2]
    Output: 2
     */
    //hashSet
    public static int findDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();

        for(int elm : arr){
            if(set.contains(elm)){
                return elm;
            }
            set.add(elm);
        }
        return -1; // if no duplicates found
    }

    // Approach 2: Using the Tortoise and Hare algorithm (Floyd's algorithm)
    public static int findDuplicates2(int[] arr){
        int slow = arr[0];
        int fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow != fast);
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static int findDuplicates3(int[] arr){
        int n = arr.length-1;
        int sum = n*(n+1)/2;
        int arraySum = 0;
        for(int elm: arr){
            arraySum += elm;
        }
        return Math.abs(arraySum-sum);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,2,2};
        System.out.println(findDuplicates3(arr));
    }
}
