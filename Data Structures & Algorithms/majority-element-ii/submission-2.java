class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> countMat = new HashMap<>();
        for(int i : nums)
        {
            countMat.put(i,countMat.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : countMat.entrySet())
        {
            if(entry.getValue() > nums.length/3)
            {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}