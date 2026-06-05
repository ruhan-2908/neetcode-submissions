class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return isPal(s.substring(0,i) + s.substring(i+1)) || isPal(s.substring(0,j) + s.substring(j+1));
            }else
            {
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean isPal(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}