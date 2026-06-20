class Solution {
    HashMap<Integer,Integer> map;
    public boolean lemonadeChange(int[] bills) {
        map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int bill : bills)
        {
            map.put(bill,map.get(bill) + 1);
            if(generate(bill)) return false;
        }
        return true;
    }

    public boolean generate(int bill)
    {
        int change = bill - 5;
        if(change == 0) return false;

        while(change >= 20 && map.get(20) > 0)
        {
            change -= 20;
            map.put(20,map.get(20)-1);
        }

        while(change >= 10 && map.get(10) > 0)
        {
            change -= 10;
            map.put(10,map.get(10) - 1);
        }

        while(change >= 5 && map.get(5) > 0)
        {
            change -= 5;
            map.put(5,map.get(5) - 1);
        }


        return change != 0;
    }
}