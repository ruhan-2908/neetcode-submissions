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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,res);
        return String.join(",",res);
    }

    public void dfs(TreeNode root, List<String> res)
    {
        if(root == null)
        {
            res.add("N");
            return;
        }
        String value = String.valueOf(root.val);
        res.add(value);
        dfs(root.left,res);
        dfs(root.right,res);
        return;
    }
    
    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] home = data.split(",");
        return dfs2(home);
    }

    public TreeNode dfs2(String[] home)
    {
        if(home[idx].equals("N"))
        {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(home[idx++]));
        root.left = dfs2(home);
        root.right = dfs2(home);
        return root;
    }
}
