class Solution {
    public int minOperations(String s) {
        int count = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            if(i % 2 == 0)
            {
                count += (s.charAt(i) == '0') ? 0 : 1;
            }else
            {
                count += (s.charAt(i) == '1') ? 0 : 1;
            }
        }

        return Math.min(count,s.length() - count);
    }
}