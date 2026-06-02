class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;
        String start = "0000";
        visited.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int moves = 0 ;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ;i < size ; i++)
            {
                String eNode = q.poll();
                if(eNode.equals(target)) return moves;
                for(String child : children(eNode))
                {
                    if(!visited.contains(child))
                    {
                        q.offer(child);
                        visited.add(child);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public List<String> children(String str)
    {
        List<String> childrens = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i++)
        {
            char[] temp = str.toCharArray();
            temp[i] =  (char) (((temp[i] - '0' + 1) % 10 ) + '0');
            childrens.add(new String(temp));

            temp = str.toCharArray();
            temp[i]  = (char) (((temp[i] - '0' - 1 + 10) % 10) + '0');
            childrens.add(new String(temp));
        }
        return childrens;
    }
}