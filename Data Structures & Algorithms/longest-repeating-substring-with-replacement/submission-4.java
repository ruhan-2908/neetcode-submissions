class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int end = 0 ; end < s.length() ; end++)
        {
            charCount.put(s.charAt(end),charCount.getOrDefault(s.charAt(end),0)+1);
            if(charCount.get(s.charAt(end)) > maxFreq) maxFreq = charCount.get(s.charAt(end));
            if(((end - start + 1) - maxFreq) > k)
            {
                charCount.put(s.charAt(start),charCount.get(s.charAt(start))-1);
                start++;
            }
            maxLen = Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
}
