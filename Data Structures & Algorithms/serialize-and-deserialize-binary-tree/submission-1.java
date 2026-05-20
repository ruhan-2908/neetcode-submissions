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
        res.add(String.valueOf(root.val));
        dfs(root.left,res);
        dfs(root.right,res);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] home = data.split(",");
        int[] i = {0};
        return dfs2(home,i);
    }

    public TreeNode dfs2(String[] home ,int[] i)
    {
        if(home[i[0]].equals("N"))
        {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(home[i[0]]));
        i[0]++;
        node.left = dfs2(home,i);
        node.right = dfs2(home,i);
        return node;
    }
}
