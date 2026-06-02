class Solution {
    public int findJudge(int n, int[][] trust) {
       int[] handle = new int[n+1];
       for(int[] hope : trust)
       {
        handle[hope[1]]++;
        handle[hope[0]]--;

       }
       for(int i=1; i<=n ;i++)
       {
        if(handle[i] == n-1) return i;
       }
       return -1;
    }
}