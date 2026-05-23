class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        if(total % 4 != 0) return false;
        int target = total / 4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks,0,target,sides);
    }
    public boolean backtrack(int[] matchsticks, int idx , int target,int[] sides)
    {
        if(idx >= matchsticks.length) return true;

        for(int j = 0  ;  j < 4 ; j++)
        {
            if(sides[j] + matchsticks[idx] > target) continue;
            sides[j] += matchsticks[idx];
            if(backtrack(matchsticks,idx+1,target,sides)) return true;
            sides[j] -= matchsticks[idx];
        }
        return false;
    }
    public void reverse(int[] nums)
    {
        for(int i = 0 ; i< nums.length /2 ; i++)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}