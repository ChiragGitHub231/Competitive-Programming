/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    void reverseOddLevelsHelper(TreeNode* left, TreeNode* right, int level) {
        // Base case: if either node is null, return
        if (!left || !right) return;

        // If the level is odd, swap the values of the nodes
        if (level % 2 == 1) {
            swap(left->val, right->val);
        }

        // Recur for the next level (left's left with right's right and left's right with right's left)
        reverseOddLevelsHelper(left->left, right->right, level + 1);
        reverseOddLevelsHelper(left->right, right->left, level + 1);
    }
    
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if (!root) return nullptr;

        // Start the recursion for the left and right subtrees at level 1 (odd).
        reverseOddLevelsHelper(root->left, root->right, 1);
        return root;
    }
};