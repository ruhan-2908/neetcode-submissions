class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        m--;
        n--;
        while(m > -1 && n > -1)
        {
            if(nums1[m] > nums2[n]) 
            {
                nums1[idx] = nums1[m];
                m--;
            }
            else
            {
                nums1[idx] = nums2[n];
                n--;
            }
            idx--;
        }   
        while(m>-1) nums1[idx--] = nums1[m--];
        while(n>-1) nums1[idx--] = nums2[n--];
    }
}