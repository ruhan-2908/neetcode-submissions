class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String sample = "";
        for(String str : strs)
        {
            if(str.length() < min)
            {
                min = str.length();
                sample = str;
            }
        }
        int i = 0;
        while(i<min)
        {
            boolean flag = true;
            for(String str : strs)
            {
                if(str.charAt(i) != sample.charAt(i)) 
                {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            i++;
        }
        return sample.substring(0,i);
    }
}