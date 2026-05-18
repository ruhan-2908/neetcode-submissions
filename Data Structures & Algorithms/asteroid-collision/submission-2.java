class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids)
        {
            while(!stack.isEmpty() && stack.peek() > 0 && ast < 0)
            {
                int diff = ast + stack.peek();
                if(diff < 0)
                {
                    stack.pop(); 
                }else if ( diff > 0)
                {
                    ast = Integer.MAX_VALUE;
                }else
                {
                    ast = Integer.MAX_VALUE;
                    stack.pop();
                }
            }
            if(ast != Integer.MAX_VALUE) stack.push(ast);
        }
        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1 ; i >=0 ; i--)
        {
            res[i] = stack.pop();
        }
        return res;
    }
}