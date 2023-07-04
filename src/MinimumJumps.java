public class MinimumJumps {

    // Approach 1: Using dynamic programming to track minimum jumps
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] jumps = new int[n];
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

// Approach 2: Optimized greedy algorithm to track minimum jumps
    public static boolean canJump(int[] nums) {
        int last = nums.length -1;
        int maxReach = 0; //maximum index upto which we can travel

        for(int i = 0; i <= maxReach; i++){
            maxReach = Math.max(maxReach,i+nums[i]);

            if(maxReach >= last){
                return true;  // we can reach the last index
            }
        }
        return false; // cannot reach last index
    }
    public static void main(String[] args) {
     int arr[] = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
