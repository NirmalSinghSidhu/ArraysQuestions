import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {
    //Find all pairs in an integer array whose sum is equal to a given number:
    public static List<List<Integer>> findPairs(int[] arr, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(complement);
                pairs.add(pair);
            }
            set.add(num);
        }

        return pairs;
    }

}
