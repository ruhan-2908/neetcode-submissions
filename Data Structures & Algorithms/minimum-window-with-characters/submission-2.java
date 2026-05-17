class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        int need = tmap.size();
        int have = 0;
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int i = 0;
        for(int j = 0 ; j < s.length() ;j++)
        {
            char ch = s.charAt(j);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch) && tmap.get(ch) == smap.get(ch))
            {
                have++;
            }
            while(have == need)
            {
                if((j-i+1) < resLen)
                {
                    res[0] = i;
                    res[1] = j;
                    resLen = j-i+1;
                }
                char cho = s.charAt(i);
                smap.put(cho,smap.get(cho)-1);
                if(tmap.containsKey(cho) && tmap.get(cho) > smap.get(cho))
                {
                    have--;
                }
                i++;
            }
        }
        return resLen!=Integer.MAX_VALUE ? s.substring(res[0],res[1]+1) : "";
    }
}
