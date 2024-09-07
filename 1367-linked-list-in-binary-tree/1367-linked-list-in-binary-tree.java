/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean dfs(TreeNode current, ListNode currentNode){
        if(current == null || current.val != currentNode.val) return false;
        if(currentNode.next == null) return true;
        return dfs(current.left, currentNode.next) || dfs(current.right, currentNode.next);
    }
    
    private boolean traverse(TreeNode current, ListNode head){
        if(current == null) return false;
        return dfs(current, head) || traverse(current.left, head) || traverse(current.right, head);
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse(root, head);
    }
}