class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0 ;
        int y = 0 ;
        set.add(x + "," + y);

        for(char ch : path.toCharArray())
        {
            if(ch == 'N') y++;
            else if(ch == 'E') x++;
            else if(ch == 'W') x--;
            else y--;

            String curr = x + "," + y;
            if(set.contains(curr)) return true;
            set.add(curr);
        }
        return false;
    }
}