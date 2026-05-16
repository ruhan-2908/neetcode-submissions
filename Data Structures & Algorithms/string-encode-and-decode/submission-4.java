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
        int i=0;
        int j=0;
        List<String> ans = new ArrayList<>();
        while(j<str.length())
        {
            while(str.charAt(j) != '#')
            {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+len;
            ans.add(str.substring(i,j));
            i=j;
        }
        return ans;
    }
}
