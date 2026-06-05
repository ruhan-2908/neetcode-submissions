class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;
        int leftMax = height[i];
        int rightMax = height[j];
        int area = 0;
        while(i<j)
        {
            if(leftMax < rightMax)
            {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                area += (leftMax - height[i]);
            }else
            {
                j--;
                rightMax = Math.max(rightMax,height[j]);
                area += rightMax - height[j];
            }
        }
        return area;
    }
}
