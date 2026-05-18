class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch == ']')
            {
                List<Character> tempString = new ArrayList<>();
                while(stack.peek() != '[') tempString.add(stack.pop());
                stack.pop();
                Collections.reverse(tempString);
                int count = 1;
                int num = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                {
                    num = ((stack.pop() - '0') * count) + num;
                    count *= 10;
                }   
                while(num > 0 )
                {
                    for(int i = 0 ; i < tempString.size() ; i++)
                    {
                        stack.push(tempString.get(i));
                    }
                    num--;
                }
            }else
            {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : stack)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
}