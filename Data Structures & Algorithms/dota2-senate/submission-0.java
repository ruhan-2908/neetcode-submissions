class Solution {
    public String predictPartyVictory(String senate) {
        char[] home = senate.toCharArray();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0; i < home.length ; i++)
        {
            if(home[i] == 'R')
            {
                r.offer(i);
            }else
            {
                d.offer(i);
            }
        }

        while(!r.isEmpty() || !d.isEmpty())
        {
            if(r.isEmpty()) return "Dire";
            if(d.isEmpty()) return "Radiant";

            if(r.peek() < d.peek())
            {
                r.offer(r.poll() + home.length);
                d.poll();
            }else
            {
                d.offer(d.poll() + home.length);
                r.poll();
            }
        }
        return "Tie";
    }
}