class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        int digit = 0 ;
        int rev = 0 ;
        while( x !=  0 )
        {
            digit = x % 10;
            x /= 10;
            if((rev > MAX / 10) || (rev == MAX / 10 && digit > MAX % 10)) return 0;
            if((rev < MIN / 10) || (rev == MIN / 10 && digit < MIN % 10)) return 0;
            
            rev = ( rev * 10 ) + digit;
        }
        return rev;
    }
}
