class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> freq = new HashMap<>();
        int i  = 0;
        int maxF = 0;
        int res = 0 ;
        for(int j = 0 ; j < s.length() ; j++)
        {
            freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
            maxF = Math.max(maxF,freq.get(s.charAt(j)));
            while( (j-i+1) - maxF > k) 
            {
                freq.put(s.charAt(i),freq.get(s.charAt(i))-1);
                i++;
            } 
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
