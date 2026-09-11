class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =  s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true; // base case : an empty suffix is always be valid or true

        // itreate backwards from end of the string
        for(int i = n; i>= 0; i--) {
            for(String w : wordDict) {
                //  check if there are enough char left and if the substring match
                if(i + w.length() <= n && s.substring (i, i+w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                // if we found the valid path from index, break early
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}