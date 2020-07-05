import java.util.*;
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i){
                return new int[]{map.get(other),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
