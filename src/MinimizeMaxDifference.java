import java.util.Arrays;

public class MinimizeMaxDifference {
    /*
    Given the heights of N towers and a value of K, Either increase or decrease the height of every tower by K (only once) where K > 0. After modifications, the task is to minimize the difference between the heights of the longest and the shortest tower and output its difference.

Examples:

Input: arr[] = {1, 15, 10}, k = 6
Output:  Maximum difference is 5.
Explanation: Change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5 (between 4 and 9). We can’t get a lower difference.

Input: arr[] = {1, 5, 15, 10}, k = 3
Output: Maximum difference is 8, arr[] = {4, 8, 12, 7}
     */

    public static int minimizeMaxDifference(int[] heights, int k){
        int n = heights.length;

        //Sorting the array
        Arrays.sort(heights);

        //Initialize the result with difference between largest and smallest heights
        int result = heights[n-1] - heights[0];

        //Modify the height to minimize the maximum difference

        int smallest = heights[0] + k;
        int largest = heights[n-1] - k;

        for(int i = 0 ; i<n-1;i++){
            int currentHeight = heights[i];
            int nextHeight = heights[i + 1];

            int increased = Math.max(currentHeight + k, largest);
            int decreased = Math.min(nextHeight - k, smallest);

            // If the decreased height becomes greater than the increased height, swap them
            if (decreased > increased) {
                int temp = decreased;
                decreased = increased;
                increased = temp;
            }

            smallest = Math.min(smallest, decreased);
            largest = Math.max(largest, increased);
        }

        // Calculate the new maximum difference
        result = Math.min(result, largest - smallest);

        return result;
    }
    public static void main(String[] args) {
        int[] heights = {1, 5, 8, 10};
        int k = 2;

        int minMaxDifference = minimizeMaxDifference(heights, k);
        System.out.println("Minimum Maximum Difference: " + minMaxDifference);
    }
}
