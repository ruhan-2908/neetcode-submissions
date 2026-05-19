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

class Pair
{
    boolean anywhere;
    int length;
    Pair(boolean anywhere, int length)
    {
        this.anywhere = anywhere;
        this.length = length;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        Pair returned =  isAnywhere(root);
        return returned.anywhere;
    }
    public Pair isAnywhere(TreeNode root)
    {
        if(root == null) return new Pair(true,0);
        Pair leftPair = isAnywhere(root.left);
        Pair rightPair = isAnywhere(root.right);
        int diff = Math.abs(leftPair.length - rightPair.length);
        boolean res = leftPair.anywhere && rightPair.anywhere && diff <= 1;
        return new Pair(res, Math.max(leftPair.length,rightPair.length) + 1);
    }
}
