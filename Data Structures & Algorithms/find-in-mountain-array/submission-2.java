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
        int i = 1;
        int j = mountainArr.length() -2;
        int pivot = -1;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            int m = mountainArr.get(mid);
            int left = mountainArr.get(mid-1);
            int right = mountainArr.get(mid+1);
            if(left < m && m < right) i = mid + 1 ;
            else if(left > m && m > right) j = mid - 1;
            else
            {
                pivot = mid;
                break;
            }
        } 
        i = 0;
        j = pivot;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            int num = mountainArr.get(mid);
            if(num < target) i = mid + 1;
            else if (num > target) j = mid - 1;
            else return mid;
        }
        i = pivot + 1;
        j = mountainArr.length()-1;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            int num = mountainArr.get(mid);
            if(num < target) j = mid - 1;
            else if (num > target) i = mid + 1;
            else return mid;
        }
        return -1;
    }
}