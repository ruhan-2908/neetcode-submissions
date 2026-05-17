class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int res = 0;
        for(int end = 0 ; end < s.length() ; end++)  
        {
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
            if((end-start+1) - maxFreq > k) 
            {
                char cho = s.charAt(start);
                map.put(cho,map.get(cho)-1);
                start++;
            }
            res = Math.max(res,end-start+1);
        }
        return res;
    }
}
