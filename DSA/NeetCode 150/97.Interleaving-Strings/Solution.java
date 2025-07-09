
class Solution {
    boolean yesRec(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        if (i + j == s3.length())
            return true;
        
        if (dp[i][j] != null)
            return dp[i][j];

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res |= yesRec(i + 1, j, s1, s2, s3, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res |= yesRec(i, j + 1, s1, s2, s3, dp);
        }

        return dp[i][j] = res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length())
            return false;
        
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        return yesRec(0, 0, s1, s2, s3, dp);
    }
}
