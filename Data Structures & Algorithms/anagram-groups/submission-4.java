class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> group = new HashMap<>();
        for(String str : strs)
        {
            int[] count = new int[26];
            for(char ch : str.toCharArray())
            {
                count[ch - 'a']++;
            }
            String rep = Arrays.toString(count);
            group.computeIfAbsent(rep,k->new ArrayList<>()).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : group.values())
        {
            ans.add(list);
        }
        return ans;
    }
}
