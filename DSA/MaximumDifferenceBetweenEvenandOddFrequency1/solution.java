import java.util.HashMap;
import java.util.Map;

public class solution {
    public int maxDifference(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) +1);
        }
        int maxOdd = 0;
        int maxEven = 0;
        for(char c : freq.keySet()){
            if(freq.get(c) % 2 == 0){
                maxEven = (maxEven == 0)? freq.get(c) : Math.min(maxEven, freq.get(c));
            }
            else{
                maxOdd = Math.max(maxOdd, freq.get(c));
            }
        }

        return maxOdd - maxEven;
    }
}
