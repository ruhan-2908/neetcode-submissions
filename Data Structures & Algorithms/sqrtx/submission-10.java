class Solution {
    public int mySqrt(int x) {
       int i = 1;
       int j = x;
       while(i<=j)
       {
            int mid = i + (j-i)/2;
            long res = (long) mid * mid;
            if(res > x) j = mid - 1;
            else if (res < x) i = mid + 1;
            else return mid;
       } 
       return i-1;
    }
}