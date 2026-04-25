class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visit = new HashSet<>(Arrays.asList(deadends));
        if(visit.contains("0000")) return -1;
        String start = "0000";
        visit.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int turns = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String str = q.poll();
                if(str.equals(target)) return turns;

                for(String child : children(str))
                {
                    if(!visit.contains(child))
                    {
                        visit.add(child);
                        q.offer(child);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
    public List<String> children(String str)
    {
        List<String> res = new ArrayList<>();
        for(int i  = 0 ; i < 4  ; i++)
        {
            char[] temp = str.toCharArray();
            temp[i] = (char) (((temp[i] - '0' + 1 )%10) + '0');
            res.add(new String(temp));

            temp = str.toCharArray();
            temp[i] = (char) (((temp[i] - '0' -1 + 10)%10) + '0');
            res.add(new String(temp));
        }
        return res;
    }
}