//Last Done at 07/01/2025
import java.util.*;
public class Solution {

   
    public String encode(List<String> strs){
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(str.length() + "#" + str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int charIndex = 0;
        while (charIndex < str.length()) {
            int number = charIndex;
            int length = 0;
            while(str.charAt(number) != '#'){
                length*=10;
                length+= Integer.valueOf(str.charAt(number));
                number++;
            }
            number++;
            res.add(str.substring(number, number + length));
            charIndex = number + length;
        }

        return res;

    }
    public static void main(String[] args) {
        
    }
}
