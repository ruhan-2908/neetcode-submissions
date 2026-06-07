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
    int k ;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        k--;
        if(k == 0) ans = root.val;
        inorder(root.right);
    }
}
