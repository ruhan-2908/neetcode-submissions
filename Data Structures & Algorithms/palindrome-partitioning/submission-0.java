class Solution {
    private List<List<String>> list;
    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        backtrack(0,s,new ArrayList<>());
        return list;
    }
    private void backtrack(int i , String s, List<String> curPart)
    {
        if(i==s.length())
        {
            list.add(new ArrayList<>(curPart));
            return;
        }

        for(int j=i;j<s.length();j++)
        {
            if(isPal(s,i,j))
            {
                curPart.add(s.substring(i,j+1));
                backtrack(j+1,s,curPart);
                curPart.remove(curPart.size() - 1);
            }
        }
    }
    private boolean isPal(String s , int i , int j)
    {
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
