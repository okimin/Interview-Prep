import java.util.*;

public class encode_decode_string {
    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();
        for(String str : strs){
            enc.append(str.length() + "^" + str);
        }
        return enc.toString();
    }

    public List<String> decode(String str) {
        //Should always start of with a number
        int decIndex = 0;
        List<String> res = new ArrayList<>();
        while(decIndex< str.length()){
            int wordLength = 0;
            while(str.charAt(decIndex) != '^'){
                wordLength = wordLength * 10 + Integer.valueOf(str.charAt(decIndex));
                decIndex++;
            }
            decIndex++;
            res.add(str.substring(decIndex, decIndex + wordLength));
            decIndex+=wordLength;
        }
        return res;
    }
}
