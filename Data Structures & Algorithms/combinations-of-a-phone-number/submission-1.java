class Solution {
    List<String> ans;
    HashMap<Character,String> map;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        sb = new StringBuilder();
        ans = new ArrayList<>();
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(digits,0);
        return ans;
    }
    public void dfs(String digits, int i)
    {
        if(i >= digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        String curr = map.get(digits.charAt(i));
        for(int j = 0 ; j < curr.length() ; j++)
        {
            sb.append(curr.charAt(j));
            dfs(digits,i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
