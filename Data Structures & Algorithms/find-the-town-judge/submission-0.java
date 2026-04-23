class Solution {
    public int findJudge(int n, int[][] trust) {
        List<Integer> list = new ArrayList<>();
        for(int[] ele : trust)
        {
            list.add(ele[1]);
        }
        int judge = list.get(0);
        for(int i = 1 ; i < list.size() ; i++)
        {
            if(list.get(i) != judge) return -1;
        }
        return judge;
    }
}