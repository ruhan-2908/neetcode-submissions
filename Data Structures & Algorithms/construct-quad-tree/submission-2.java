/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return formIt(grid,0,0,grid.length);
    }
    public Node formIt(int[][] grid, int i , int j, int n)
    {
        if(n==1) return new Node(grid[i][j] == 1, true);

        n = n / 2;
        Node topLeft = formIt(grid,i,j,n);
        Node topRight = formIt(grid,i,j+n,n);
        Node bottomLeft = formIt(grid,i+n,j,n);
        Node bottomRight = formIt(grid,i+n,j+n,n);

        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
         && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val)
        {
            return new Node(topLeft.val,true);
        }
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}