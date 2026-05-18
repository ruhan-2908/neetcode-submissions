class FreqStack {
    List<Integer> stack ;
    Map<Integer,Integer> count;
    public FreqStack() {
        count = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        count.put(val,count.getOrDefault(val,0)+1);
    }
    
    public int pop() {
        int max = Collections.max(count.values());
        int length = stack.size() - 1;
        int i;
        for(i = length ; i > -1 ; i--)
        {
                if(count.get(stack.get(i)) == max)
                {
                        break;
                }
        }
        int res = stack.remove(i);
        count.put(res,count.get(res)-1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */