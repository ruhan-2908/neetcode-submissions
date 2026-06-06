class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int r = rows * cols - 1;
        while(i <= r)
        {
            int m = i + (r-i)/2;
            int row = m / cols;
            int col = m % cols;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) r = m - 1;
            else i = m + 1;
        }
        return false;
    }
}
