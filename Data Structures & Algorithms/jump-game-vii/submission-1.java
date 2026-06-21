class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if(s.charAt(len-1) == '1') return false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int farthest = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            int start = Math.max(farthest+1,curr+minJump);

            for(int j = start ; j < Math.min(len,curr+maxJump+1) ; j++)
            {
                if(s.charAt(j) == '0')
                {
                    if(j == len - 1) return true;
                    q.offer(j);
                }
            }

            farthest = curr + maxJump;
        }

        return false;
    }
}