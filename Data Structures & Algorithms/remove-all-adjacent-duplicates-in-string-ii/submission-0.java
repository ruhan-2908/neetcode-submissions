class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
            stack.push(ch);
            if(stack.size() >= k)
            {
                List<Character> list = new ArrayList<>();
                for(int i =0 ; i < k ; i++) list.add(stack.pop());
                Collections.reverse(list);
                if(!matching(list))
                {
                    for(char e : list) stack.push(e);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
    public boolean matching(List<Character> list)
    {
        Character u = list.get(0);
        for(char ch : list)
        {
            if(u != ch) return false;
        }
        return true;
    }
}