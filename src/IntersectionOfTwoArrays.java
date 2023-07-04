import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static ArrayList<Integer> findIntersection(int arr1[] ,int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int elem : arr1){
            set.add(elem);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int elm : arr2){
            if(set.contains(elm)){
                ans.add(elm);
            }
        }
        return ans;
    }
    //merge Sort Approach
    public  static ArrayList<Integer> findIntersection2(int[] arr1,int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {2,4,5,6,7,8};

        ArrayList<Integer> ans = findIntersection2(arr1,arr2);
        System.out.println(ans);
    }
}
