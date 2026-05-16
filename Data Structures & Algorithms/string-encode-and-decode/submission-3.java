class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs)
        {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i =0;
        int j = 0;
        while(i<str.length())
        {
            while(str.charAt(j) != '#')
            {
                j++;
            }
            int count = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + count;
            ans.add(str.substring(i,j));
            i=j;
        }
        return ans;
    }
}
