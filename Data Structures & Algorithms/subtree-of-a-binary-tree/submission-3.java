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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;
        if(findSame(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean findSame(TreeNode root, TreeNode sample)
    {
        if(root == null && sample == null) return true;
        if(root == null || sample == null) return false;
        boolean isLeftMatches = findSame(root.left,sample.left);
        boolean isRightMatches = findSame(root.right,sample.right);
        return root.val == sample.val && isLeftMatches && isRightMatches;
    }
}
