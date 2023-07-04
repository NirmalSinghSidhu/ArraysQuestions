import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap,
     merge them into [1,6].
     */

    public static int[][] mergeIntervals(int[][] intervals){
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for(int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            }else{
                currentInterval = interval;
                mergedList.add(currentInterval);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = {
                {1,3},{2,6},{8,10},{15,18}
        };
        int ans[][] = mergeIntervals(intervals);
        for(int[] inter : ans){
            System.out.print("[");
            for(int elm: inter){
                System.out.print(elm+" ,");
            }
            System.out.print("]");
        }
    }
}
