class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length+1][matrix[0].length+1];
        for(int r = 0 ; r < matrix.length ; r++)
        {
            int slide = 0;
            for(int c = 0 ; c < matrix[0].length ; c++)
            {
                slide += matrix[r][c];
                prefix[r+1][c+1] = slide + prefix[r][c+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottom = prefix[row2+1][col2+1];
        int topLeft = prefix[row1][col1];
        int top = prefix[row1][col2+1];
        int left = prefix[row2+1][col1];
        return bottom - top - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */