class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens)
        {
            if(str.equals("+"))
            {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1+n2);
            }else if ( str.equals("-"))
            {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1-n2);
            }else if ( str.equals("*"))
            {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1*n2);
            }else if (str.equals("/"))
            {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1/n2);
            }else
            {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
