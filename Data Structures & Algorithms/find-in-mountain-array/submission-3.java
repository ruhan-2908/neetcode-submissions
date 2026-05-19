/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i = 0;
        int j = mountainArr.length() - 1;
        int pivot = 0;
        while(i<=j)
        {
            int m = i + (j-i)/2;
            int mid = mountainArr.get(m);
            int left = mountainArr.get(m-1);
            int right = mountainArr.get(m+1);

            if(left < mid && mid < right)
            {   
                i = m + 1;
            }else if ( left > mid && mid > right)
            {
                j = m - 1;
            }else
            {
                pivot = m;
                break;
            }
        }   
        i = 0;
        j = pivot;
        while(i<=j)
        {
            int m = i + (j-i)/2;
            int mid = mountainArr.get(m);
            if(mid < target)
            {
                i = m + 1;
            }else if( mid > target)
            {
                j = m - 1;
            }else
            {
                return m;
            }
        }
        i = pivot+1;
        j = mountainArr.length() - 1;
        while(i<=j)
        {
            int m = i + (j-i)/2;
            int mid = mountainArr.get(m);
            if(mid < target)
            {
                j = m - 1;
            }else if(mid > target)
            {
                i = m + 1;
            }else
            {
                return m;
            }
        }
        return -1;
    }
}