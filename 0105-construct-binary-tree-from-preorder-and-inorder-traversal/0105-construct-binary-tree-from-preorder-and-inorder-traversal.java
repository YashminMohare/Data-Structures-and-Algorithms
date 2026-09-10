/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length-1, preorder, inorder);
    }
    private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // base case : if we ran out of node to procee
        if(preStart > preorder.length-1 || inStart > inEnd) {
            return null;
        }
        // first element in preorder traversal is always the root value
        TreeNode root = new TreeNode(preorder[preStart]);

        // find the index of root node in inorder array
        int mid = 0;
        for(int i = inStart; i<= inEnd; i++) {
            if(inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        // now recursively construct left and right subtree
        
        root.left = build(preStart +1, inStart, mid-1, preorder, inorder );
        root.right = build(preStart + (mid - inStart ) +1, mid+1, inEnd, preorder, inorder);

        return root;
    }
}