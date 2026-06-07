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
                                                                                this.bottomRight =
null;
                                                                                    }

                                                                                            public
Node(boolean val, boolean isLeaf) { this.val = val; this.isLeaf = isLeaf; this.topLeft = null;
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
        return formIt(0, 0, grid.length, grid);
    }
    public Node formIt(int r, int c, int n, int[][] grid) {
        if (n == 1)
            return new Node(grid[r][c] == 1, true);
        n = n / 2;
        Node topLeft = formIt(r, c, n, grid);
        Node topRight = formIt(r, c+n, n, grid);
        Node bottomLeft = formIt(r+n, c, n, grid);
        Node bottomRight = formIt(r + n, c + n, n, grid);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && topRight.val == bottomLeft.val
            && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}