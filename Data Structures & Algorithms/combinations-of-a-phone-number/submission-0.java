class Solution {
    private List<String> list = new ArrayList<>();
    private String[] home ={"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return list;
        backtrack(0,digits,"");
        return list;
    }
    private void backtrack(int i , String digits, String cur)
    {
        if(digits.length() == cur.length())
        {
            list.add(cur);
            return;
        }
        for(char ch : home[digits.charAt(i) - '0'].toCharArray())
        {
            backtrack(i+1,digits,cur+ch);
        }
    }
}
