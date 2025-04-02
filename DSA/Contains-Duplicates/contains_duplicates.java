/*
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

 */

import java.util.HashSet;
import java.util.Set;

public class contains_duplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num : nums){
            if(unique.contains(num))
                return true;
            unique.add(num);
        }
        return false;
    }
}
