class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int prev = 0;
        int res = 0;
        for(int i = s.length() - 1 ; i >=0 ; i--)
        {
            int curr =map.get(s.charAt(i));

            if(curr < prev)
            {
                res -= curr;
            }else
            {
                res += curr;
            }

            prev=curr;
        }

        return res;
    }
}