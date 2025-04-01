import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map< Integer, Integer> numMap = new HashMap<>();
        //numMap.put(nums[0], 0);
        for(int x = 0; x< nums.length; x++){
            if(numMap.containsKey(target - nums[x]))
                return new int[]{numMap.get(target - nums[x]), x};
            numMap.put(nums[x],x);
        }
        return new int[]{-1,-1};

    }
}
