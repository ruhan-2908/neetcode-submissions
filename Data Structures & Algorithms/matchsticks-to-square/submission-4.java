class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        if(totalLength % 4 != 0) return false;
        int target = totalLength / 4;
        int[] sides = new int[4];
        return dfs(matchsticks,sides,0,target);
    }
    public void reverse(int[] temp)
    {
        for(int i = 0 ; i< temp.length / 2 ;i++)
        {
            int t = temp[i];
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = t;
        }
    }
    public boolean dfs(int[] matchsticks,int[] sides,int i, int target)
    {
        if(i == matchsticks.length) return true;

        for(int j = 0; j < 4 ;j++)
        {
            if(sides[j] + matchsticks[i] <= target)
            {
                sides[j] += matchsticks[i];
                if(dfs(matchsticks,sides,i+1,target)) return true;
                sides[j] -= matchsticks[i];
            }
        }
        
        return false;
    }
}