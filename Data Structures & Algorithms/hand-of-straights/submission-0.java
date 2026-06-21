class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int h : hand) countMap.put(h,countMap.getOrDefault(h,0)+1);
        int guys = hand.length / groupSize;
        while(guys > 0)
        {   
            int start = -1;
            for(int i = 0 ; i < hand.length ; i++)
            {
                if(countMap.containsKey(hand[i]))
                {
                    start = hand[i];
                    break;
                } 
            }
            if(start == -1) return false;
            if(!formGroup(start,countMap,groupSize)) return false;
            guys--;
        }

        return true;
    }
    public boolean formGroup(int start , HashMap<Integer,Integer> countMap,int groupSize)
    {
        for(int i = 0 ; i < groupSize ; i++)
        {
            if(!countMap.containsKey(start + i)) return false;
            else 
            {
                countMap.put(start+i,countMap.get(start+i) - 1);
                if(countMap.get(start+i) == 0)
                {
                    countMap.remove(start + i);
                }
            }
        }


        return true;
    }
}
