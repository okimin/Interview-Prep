
public class Solution {

    /*
     * Example: seq = "LL"
     * Output: "LL"
     * • Example: seq = "2LR"
     * Output: "LRR". The '2' indicates that
     * we need to do "LR" first and then "R".
     * • Example: seq = "2L"
     * Output: "L". The '2' indicates that we
     * need to do "L" first and then .. (the empty string).
     * • Example: seq = "22LR"
     * Output: "LRRLR". The first '2' indicates that we need to do "2LR" first and
     * then "LR".
     * • Example: seq = "LL2R2L"
     * Output: "LLRLL"
     */

    public String moves(String input) {
        if (input.length() == 0)
            return "";
        if (input.charAt(0) == '2') {
            return moves(input.substring(1)) + moves(input.substring(2));
        }
        return input.charAt(0) + moves(input.substring(1));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.moves("LL")); // Output: "LL"
        System.out.println(solution.moves("2LR")); // Output: "LRR"
        System.out.println(solution.moves("2L")); // Output: "L"
        System.out.println(solution.moves("22LR")); // Output: "LRRLR"
        System.out.println(solution.moves("LL2R2L")); // Output: "LLRLL"
    }
    
}