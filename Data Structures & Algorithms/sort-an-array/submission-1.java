class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public void quicksort(int[] nums, int start , int end)
    {
        if(end <= start) return;

        int pivot = partition(nums,start,end);
        quicksort(nums,start,pivot-1);
        quicksort(nums,pivot+1,end);
    }
    public int partition(int[] nums, int start , int end)
    {
        int i = start - 1;
        int pivot = nums[end];
        for(int j = start ; j < end ; j++)
        {
            if(nums[j] <= pivot)
            {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[end];
        nums[end] = nums[i];
        nums[i] = temp;
        return i;
    }
}