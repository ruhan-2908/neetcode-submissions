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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, int min , int max)
    {
        if(root == null) return true;
        boolean lefto = isValid(root.left,min,root.val);
        boolean righto = isValid(root.right,root.val, max);
        boolean tdy = min < root.val && root.val < max;
        return tdy && lefto && righto;
    }
}
