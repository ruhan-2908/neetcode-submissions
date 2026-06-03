class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if(visited.contains(start)) return -1;
        visited.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                String curr = q.poll();
                if(curr.equals(target)) return level;

                for(String child : children(curr))
                {
                    if(!visited.contains(child))
                    {
                        visited.add(child);
                        q.offer(child);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public List<String> children(String curr)
    {
        List<String> children = new ArrayList<>();
        for(int i = 0 ;i < 4 ; i++)
        {
            char[] temp = curr.toCharArray();
            temp[i] = (char) (((temp[i] - '0' + 1)%10) + '0');
            children.add(new String(temp));

            temp = curr.toCharArray();
            temp[i] = (char) (((temp[i] - '0' - 1 + 10)%10) + '0');
            children.add(new String(temp));
        }
        return children;
    }
}