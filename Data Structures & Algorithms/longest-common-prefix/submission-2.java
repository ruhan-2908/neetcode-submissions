class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallest = strs[0];
        for(String str : strs)
        {
            if(str.length() < smallest.length())
            {
                smallest = str;
            }
        }
        int i;
        for(i= 0 ;i < smallest.length() ;i++)
        {
            boolean flag = false;
            for(String str: strs)
            {
                if(smallest.charAt(i) != str.charAt(i))
                {
                    flag = true;
                    break;
                    
                }
            }
            if(flag) break;
        }
        return smallest.substring(0,i);
    }
}