class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0 ;
        int r = 1 ;
        char prev = ' ';
        int max = 1;
        while(r < arr.length)
        {
            if(arr[r] > arr[r-1] && prev != '>')
            {
                max = Math.max(max,r-l+1);
                r += 1;
                prev = '>';
            }else if(arr[r] < arr[r-1] && prev != '<')
            {
                max = Math.max(max,r-l+1);
                r += 1;
                prev = '<';
            }else
            {
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                prev = ' ';
            }
        }

        return max;
    }
}