class Solution {
    public int maxDepth(String s) {
        int depth =0;
        int r = 0;
        for(char c : s.toCharArray()) {
            if(c == ')') {
                depth--;
                continue;
            }
            // digit and operation
            if(c!='(') continue;
            depth++;
            // new max only possible after '('
            if(depth > r) {
                r = depth;
            }

        }
        return r;
    }
}