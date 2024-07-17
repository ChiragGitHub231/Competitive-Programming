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
    public TreeNode traverse(TreeNode node, boolean hasParent, Set<Integer> badNodes, List<TreeNode> ans){
        if(node == null) return null;
        if(!badNodes.contains(node.val)){
            if(!hasParent) ans.add(node);
            node.left = traverse(node.left, true, badNodes, ans);
            node.right = traverse(node.right, true, badNodes, ans);
        } else {
            traverse(node.left, false, badNodes, ans);
            traverse(node.right, false, badNodes, ans);
            node.left = node.right = null;
            return null;
        }
        return node;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> badNodes = new HashSet<>();
        for(int value : to_delete) badNodes.add(value);
        
        List<TreeNode> ans = new ArrayList<>();
        traverse(root, false, badNodes, ans);
        
        return ans;
    }
}