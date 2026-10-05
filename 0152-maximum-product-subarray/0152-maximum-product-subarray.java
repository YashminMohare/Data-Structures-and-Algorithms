class Solution {
    // we use two pointer approch l  qnd r 
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = 1;
        int ans = nums[0];

        for(int i = 0; i< n; i++) {
            // if any of l and r become 0 then update it to 1;
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];
            r *= nums[n-1-i];

            ans = Math.max(ans, Math.max(l,r)); 
        }
        return ans;
    }
}