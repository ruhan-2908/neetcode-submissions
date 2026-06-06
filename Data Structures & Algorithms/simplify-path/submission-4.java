class Solution {
    public String simplifyPath(String path) {
        String[] home = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String h : home)
        {
            if(h.equals(".")|| h.equals("")) continue;
            if(h.equals(".."))
            {
                if(!stack.isEmpty()) stack.pop();
            }else
            {
                stack.push(h);
            }
        }   
        StringBuilder sb = new StringBuilder();
        for(String str : stack)
        {
            sb.append("/").append(str);
        }
        return stack.isEmpty() ? "/" : sb.toString();
    }
}