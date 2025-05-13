import java.util.HashSet;
import java.util.Set;
// LeetCode Link 
// https://leetcode.com/problems/calculate-score-after-performing-instructions/description/
public class calculating_score_after_performing_instructions {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int index = 0;
        Set<Integer> visited = new HashSet<>();

        while(index >= 0 && index < instructions.length && !visited.contains(index)){
            visited.add(index);
            if(instructions[index].equals("add")){
                score += values[index];
                index++;
            }
            else {
                index += (values[index]);
            }
        }

        return score;
        
    }
}
