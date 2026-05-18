class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations)
        {
            if(op.equals("+"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1);
                stack.push(num2);
                stack.push(num1+num2);
            }else if(op.equals("C"))
            {
                stack.pop();
            }else if ( op.equals("D"))
            {
                int num = stack.pop();
                stack.push(num);
                stack.push(num*2);
            }else
            {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum  = 0;
        for(int i : stack)
        {
            sum += i;
        }
        return sum;
    }
}