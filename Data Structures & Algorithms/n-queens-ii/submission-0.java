class Solution {
    private HashSet<Integer> posDia = new HashSet<>();
    private HashSet<Integer> negDia = new HashSet<>();
    private HashSet<Integer> col = new HashSet<>();
    private int count = 0;
    public int totalNQueens(int n) {
        backtrack(0,n);
        return count;
    }
    public void backtrack(int r , int n)
    {
        if(r == n)
        {
            count++;
            return;
        }
        for(int c = 0 ; c< n ; c++)
        {
            if(col.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)) continue;

            col.add(c);
            posDia.add(r+c);
            negDia.add(r-c);

            backtrack(r+1,n);

            col.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);
        }
    }
}