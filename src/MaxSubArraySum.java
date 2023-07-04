public class MaxSubArraySum {

    // Approach 1: Kadane's algorithm for maximum subarray sum
    public static int findMaxSubArraySum(int[] arr){
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for(int i = 1;i<arr.length;i++){
            maxEndingHere = Math.max(arr[i],maxEndingHere+arr[i]);
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + findMaxSubArraySum(a));
    }
}
