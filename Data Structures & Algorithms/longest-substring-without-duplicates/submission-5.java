class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for(int end = 0 ; end < s.length() ; end++)
        {
            char ch = s.charAt(end);
            if(map.containsKey(ch))
            {
                start = Math.max(start,map.get(ch)+1);
            }
            res = Math.max(end-start+1,res);
            map.put(ch,end);
        }
        return res;
    }
}
