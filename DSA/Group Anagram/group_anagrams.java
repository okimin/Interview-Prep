import java.util.*;

public class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            ans.putIfAbsent(key, new ArrayList<String>());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
