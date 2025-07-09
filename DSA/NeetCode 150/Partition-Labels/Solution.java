import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String s) {
       Map<Character, int[]> interMap = new HashMap<>();
       int index = 0;
       for(Character c : s.toCharArray()){
            interMap.putIfAbsent(c, new int[]{index, index});
            interMap.get(c)[1] = index;
            index++;
       }
       List<int []> intervals = new ArrayList<>();
       for(Character c : interMap.keySet()){
            intervals.add(interMap.get(c));
       }
       Collections.sort(intervals, (a,b) -> a[0] - b[0]);
       for(int [] inter : intervals){
        System.out.println(inter[0] + " " + inter[1]);
       }
       int [] interval = intervals.get(0);
       List<int[]> merged = new ArrayList<>();
       for(int x = 1; x < intervals.size(); x++){
            int low = Math.max(interval[0], intervals.get(x)[0]);
            int high = Math.min(interval[1], intervals.get(x)[1]);
            if(low <= high){
                interval = new int[] {Math.min(interval[0], intervals.get(x)[0]), Math.max(interval[1], intervals.get(x)[1])};
            }
            else {
                merged.add(interval);
                interval = intervals.get(x);
            }
       }
       merged.add(interval);
       List<Integer> res = new ArrayList<>();
       for(int [] inter : merged){
        res.add(inter[1] -inter[0] +1);
       }

       return res;
    }
}