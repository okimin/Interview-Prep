class Solution {
    /*
    G - String s, int k
    Goal is to remove k adjacent duplicates at a time. Until we have string with no k adjecent duplicates values
    HashMap  -> Maybe can be done but will complex in ordering 
    Stack - > Can store a pair of char and int and delete when int is == k
    With rest of stack then create a StringBuilder and increment in front
    */
    public String removeDuplicates(String s, int k) {
        //Create a stack of Pair
        Deque<Pair<Character, Integer>> freqStack = new ArrayDeque<>();

        /*
        deeedbbcccbdaa
        
        d = 3
        */
        for (char c : s.toCharArray()) {
            int freq = 1;
            if (!freqStack.isEmpty() && freqStack.peek().getKey() == c) {
                freq = freqStack.peek().getValue() + 1;
                freqStack.pop();
            }
            if (freq != k) {
                freqStack.push(new Pair(c, freq));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!freqStack.isEmpty()) {
            Pair<Character, Integer> pair = freqStack.pop();
            res.insert(0, pair.getKey().toString().repeat(pair.getValue()));
        }

        return res.toString();
    }
}