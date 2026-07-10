class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String op : logs)
        {
            if(op.equals("./")) continue;
            else if(op.equals("../"))
            {
                if(!stack.isEmpty()) stack.pop();
            }else
            {
                stack.push(op);
            }
        }
        return stack.size();
    }
}