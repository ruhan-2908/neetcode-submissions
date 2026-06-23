class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int carry = 0;
        while(i < a.length() || j < b.length())
        {
            int x = 0;
            int y = 0;
            if(i < a.length())
            {  x = (a.charAt(i) - '0'); i++;
            }
            if(j < b.length()) 
            {
                y = (b.charAt(j) - '0'); j++;
            }
            int sum = carry + x + y;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) sb.append("1");
        return sb.reverse().toString();
    }
}