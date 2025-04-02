
/*
 * 
 * 
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Left point be at index 0
Right pointer be at index 1
[a,b] -> [left, right)
[0,1,2,4,5,7]

right -> 1 -> 1 right -1 -> 0-> 0 right ++
-------> 2- 1 == 1 right++
4-1 = 3 =/= 2 add "nums[left]->nums[right-1]" left = 3 right ++ -> 4
nums[right] = 5 nums[right -1] = 4 5-1 = 4 yes right++
"4->5" left = 6 right ++
left == right-1 -> "7"

[0,2,4,5,7]
res = {}
left = 0
right = 1

nums[rightIndex] = 2  nums[rightIndex - 1] = 0
2-1 == 0 No so then do condition is left == rightIndex - 1 ->> res = {"0"}
left = 1
right++ -> 2

nums[rightIndex] = 4  nums[rightIndex - 1] = 2
4-1 ==2 No  so then do condtion is left == right -1 ->> res = {"0", "2"}
left =2
right ++ -> 3

nums[rightIndex] = 5  nums[rightIndex - 1] = 4
5-1 == 4 yes so we dont do condition
right++ -> 4

nums[rightIndex] = 7  nums[rightIndex - 1] = 5
7-1 == 5 No so we do contion is left == right -1 No so -> res = {"0", "2", "4->5"}
left = right = 4
right ++ -> 5

out of for loop one last add
left = right -1 -> res = {"0", "2", "4->5", "7"}

 */

import java.util.*;
public class summary_ranges {

    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right;
        List<String> res = new ArrayList<>();
        for(right = 1; right < nums.length ; right++){
            if(!(nums[right-1] == (nums[right]-1))){
                if(left== right -1){
                    res.add(String.valueOf(nums[left]));
                }
                else{
                    res.add(String.valueOf(nums[left]) + "->"+String.valueOf(nums[right -1]) );
                }
                left =right;
            }
        }

        if(left== right -1){
            res.add(String.valueOf(nums[left]));
        }
        else{
            res.add(String.valueOf(nums[left]) + "->"+String.valueOf(nums[right -1]) );
        }
        return res;
    }
}
