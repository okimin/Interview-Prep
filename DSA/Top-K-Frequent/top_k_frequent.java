import java.util.*;

public class top_k_frequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
        }
        //Create a minHeap that stores the biggest frequencies
        PriorityQueue<Integer> frequencyHeap = new PriorityQueue<>(
            (a,b) -> (frequencyMap.get(a) !=frequencyMap.get(b))?frequencyMap.get(a) - frequencyMap.get(b): b-a);
        for(int num : frequencyMap.keySet()){
            frequencyHeap.add(num);
            if(frequencyHeap.size() > k)
                frequencyHeap.poll();
        }


        int [] res = new int[k];
        for(int x = 0; x< res.length; x++){
            res[x] = frequencyHeap.poll();
        }

        return res;


    }
}
