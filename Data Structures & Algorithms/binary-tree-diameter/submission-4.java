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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lefto = dfs(root.left);
        int righto = dfs(root.right);
        int currDia = lefto + righto;
        if(currDia > max) max = currDia;
        return 1 + Math.max(lefto,righto);
    }
}
