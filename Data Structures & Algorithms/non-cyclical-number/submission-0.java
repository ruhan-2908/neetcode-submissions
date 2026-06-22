class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> set =new HashSet<>();
        while(true)
        {
            n = sum(n);
            if(n == 1) return true;
            if(set.contains(n)) return false;
            set.add(n);
        }
    }
    public int sum(int n)
    {
        int ans = 0;
        while(n > 0)
        {
            ans += (n % 10) *(n % 10);
            n /= 10;
        }
        return ans;
    }
}
