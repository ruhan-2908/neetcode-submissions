class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);

        for(String str : words)
        {
            int[] curr = new int[26];
            for(char ch : str.toCharArray())
            {
                curr[ch - 'a']++;
            }

            for(int i = 0 ; i < 26 ; i++)
            {
                count[i] = Math.min(count[i],curr[i]);
            }
        }


        List<String> ans = new ArrayList<>();

        for(int i = 0 ; i < 26 ; i++)
        {
            for(int j = 0 ; j < count[i] ; j++)
            {
                ans.add(((char)( i + 'a')) + "");
            }
        }

        return ans;
    }
}