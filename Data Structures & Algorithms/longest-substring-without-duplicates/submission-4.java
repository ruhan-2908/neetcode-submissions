class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start  = 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int end = 0 ; end < s.length() ; end++)
        {
            if(map.containsKey(s.charAt(end)))
            {
                start = Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end),end);
            res = Math.max(res,end-start+1);
        }
        return res;
    }
}
