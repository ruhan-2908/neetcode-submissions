class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        HashMap<Integer,List<Integer>> countToNums = new HashMap<>();
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            countToNums.computeIfAbsent(entry.getValue(),n-> new ArrayList<>()).add(entry.getKey());
            if(entry.getValue() > maxFreq) maxFreq = entry.getValue();
        }
        int idx = 0;
        while(true && idx != k)
        {
            while(!countToNums.containsKey(maxFreq)) maxFreq--;
            List<Integer> list = countToNums.get(maxFreq);
            for(int i =0 ;i < list.size() ; i++)
            {
                ans[idx++] = list.get(i);
                if(idx == k) return ans;
            }
            maxFreq--;
        }
        return ans;
    }
}
