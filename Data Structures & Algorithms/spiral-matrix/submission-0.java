class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colStart <= colEnd)
        {
            for(int c = colStart ; c <= colEnd ; c++)
            {
                ans.add(matrix[rowStart][c]);
            }
            rowStart++;

            for(int r = rowStart ; r <= rowEnd ; r++)
            {
                ans.add(matrix[r][colEnd]);
            }

            colEnd--;

            if(rowStart <= rowEnd)
            {
                for(int c = colEnd ; c >= colStart ; c--)
                {
                    ans.add(matrix[rowEnd][c]);
                }
                rowEnd--;
            }
                
            if(colStart <= colEnd)
            {
                for(int r = rowEnd ; r >= rowStart ; r--)
                {
                    ans.add(matrix[r][colStart]);
                }
                colStart++;
            }
        }

        return ans;
    }
}
