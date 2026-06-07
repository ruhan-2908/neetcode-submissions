class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        if (b.length < a.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int total = a.length + b.length;
        int half = total / 2;
        int l = 0;
        int r = a.length - 1;
        while (true) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int aLeft = (i > 0) ? a[i - 1] : Integer.MIN_VALUE;
            int bLeft = (j > 0) ? b[j - 1] : Integer.MIN_VALUE;
            int aRight = (i < a.length) ? a[i] : Integer.MAX_VALUE;
            int bRight = (j < b.length) ? b[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 1) {
                    return ((double) Math.min(aRight, bRight));
                }
                return ((double) Math.max(aLeft, bLeft) + (double) Math.min(aRight, bRight)) / 2;
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}
