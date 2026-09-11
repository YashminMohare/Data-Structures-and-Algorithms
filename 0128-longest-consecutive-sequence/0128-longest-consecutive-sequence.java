class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int i : nums) {
            set.add(i);
        }
        for(int num : set) {
            // num is beginning of a sequence 
                int current  = num;
            if(!set.contains(num - 1)) {
                int length = 1;

                while(set.contains(current +1 )) {
                    current++;
                    length++;
                }
            longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}