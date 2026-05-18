class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] patho = path.split("/");
        for(String s : patho)
        {
            if(s.equals("") || s.equals(".")) continue;
            else if ( s.equals(".."))
            {
                if(!stack.isEmpty()) stack.pop();
            }else
            {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : stack)
        {
            sb.append("/").append(str);
        }
        return sb.length() == 0 ? "/": sb.toString();
    }
}