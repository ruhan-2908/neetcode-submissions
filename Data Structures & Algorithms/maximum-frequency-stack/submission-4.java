class FreqStack {
    List<Integer> list;
    HashMap<Integer,Integer> count;
    public FreqStack() {
        list = new ArrayList<>();
        count = new HashMap<>();
    }
    
    public void push(int val) {
        list.add(val);
        count.put(val,count.getOrDefault(val,0)+1);
    }
    
    public int pop() {
        int max = Collections.max(count.values());
        int i = list.size() - 1;
        while(i > -1)
        {
            if(count.get(list.get(i)) == max)
            {
                break;
            }
            i--;
        }
        int res = list.remove(i);
        count.put(res,count.get(res) - 1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */