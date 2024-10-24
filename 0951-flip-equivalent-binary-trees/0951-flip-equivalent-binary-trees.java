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
    private boolean sameChildren(TreeNode root1, TreeNode root2) {
        boolean sameLeft = false, sameRight = false;
        
        if(root1.left == null && root2.left == null) sameLeft = true;
        else if(root1.left == null || root2.left == null) sameLeft = false;
        else sameLeft = root1.left.val == root2.left.val;
        
        if(root1.right == null && root2.right == null) sameRight = true;
        else if(root1.right == null || root2.right == null) sameRight = false;
        else sameRight = root1.right.val == root2.right.val;
        
        return sameLeft && sameRight;
    }
        
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        
        if(root1 == null || root2 == null) return false;
        
        if(root1.val != root2.val) return false;
        
        if(!sameChildren(root1, root2)) {
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }
        
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}