class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String,List<String>> map = new HashMap<>();
      for(String str : strs)
      {
        int[] check = new int[26];
        for(char ch : str.toCharArray())
        {
            check[ch - 'a']++;
        }
        String temp = Arrays.toString(check);
        map.putIfAbsent(temp,new ArrayList<>());
        map.get(temp).add(str);
      }  
      List<List<String>> list = new ArrayList<>();
      for(List<String> listo : map.values())
      {
        list.add(listo);
      }
      return list;
    }
}
