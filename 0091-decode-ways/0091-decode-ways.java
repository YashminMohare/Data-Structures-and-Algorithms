class Solution {
    private int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;
        return dfs(0, s);
    }
    private  int dfs(int i , String s) {
        if(dp[i] != -1) {
            return dp[i];
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        //take one digit
        int res = dfs(i+1 ,s);

        // take 2 digit
        if(i+1 < s.length() &&
         (s.charAt(i) == '1' || 
         (s.charAt(i)== '2' && 
          s.charAt(i+1) >= '0'  && 
          s.charAt(i+1) <= '6'))) {
                res += dfs(i+2, s);
        }

        dp[i] = res;
        return res;
    }
}