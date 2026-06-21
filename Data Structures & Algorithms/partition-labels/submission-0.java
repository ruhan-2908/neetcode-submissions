class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ;i < s.length() ; i++) map.put(s.charAt(i),i);

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = map.get(s.charAt(start));
        while(start < s.length())
        {
            end = map.get(s.charAt(start));
            for(int i = 0 ; i < end ; i++) end = Math.max(end,map.get(s.charAt(i)));
            ans.add(end - start + 1);
            start = end + 1;
        }
        return ans;
    }
}
