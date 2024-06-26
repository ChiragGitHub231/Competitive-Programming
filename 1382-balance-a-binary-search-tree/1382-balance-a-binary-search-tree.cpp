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
public:
    TreeNode* solve2(vector<int>&v, int start, int end){
        if(start>end) return NULL;
        int middle=(start+end)/2;
        TreeNode* root=new TreeNode(v[middle]);
        root->left=solve2(v,start,middle-1);
        root->right=solve2(v,middle+1,end);
        return root;
    }
    
    void solve1(TreeNode* root, vector<int>&v){
        if(!root) return;
        solve1(root->left,v);
        v.push_back(root->val);
        solve1(root->right,v);
    }
    
    TreeNode* balanceBST(TreeNode* root) {
        vector<int>v;
        solve1(root,v);
        return solve2(v,0,v.size()-1);
    }
};