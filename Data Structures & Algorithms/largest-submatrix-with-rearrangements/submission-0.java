class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int res =0;
        for(int r = 1 ; r < rows ; r++)
        {
            for(int c = 0 ; c < cols ; c++)
            {
                if(matrix[r][c] > 0)
                {
                    matrix[r][c] += matrix[r-1][c];
                }
            }
        }

        for(int r = 0 ; r < rows ; r++)
        {
            Arrays.sort(matrix[r]);
            for(int c = 0 ; c < cols ; c++)
            {
                res = Math.max(res,(cols - c) * matrix[r][c]);
            }
        }

        return res;
    }
}