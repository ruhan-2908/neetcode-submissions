class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ;i < asteroids.length ; i++)
        {
            while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0)
            {
                int diff = Math.abs(stack.peek()) - Math.abs(asteroids[i]);
                if(diff == 0)
                {
                    stack.pop();
                    asteroids[i] = Integer.MAX_VALUE;
                }else if ( diff  <  0)
                {
                    stack.pop();
                }else
                {
                    asteroids[i] = Integer.MAX_VALUE;
                }
            }
            if(asteroids[i] != Integer.MAX_VALUE) stack.push(asteroids[i]);
        }
        int[] ans = new int[stack.size()];
        int idx = 0 ;
        for(int i : stack)
        {
            ans[idx++] = i;
        }
        return ans;
    }
}