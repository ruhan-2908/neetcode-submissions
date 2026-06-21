class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;

        for(int[] t : triplets)
        {
            x = x || (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]);
            y = y || (t[1] == target[1] && t[0] <= target[0] && t[2] <= target[2]);
            z = z || (t[2] == target[2] && t[0] <= target[0] && t[1] <= target[1]);

            if(x && y && z) return true;

        }

        return false;
    }
}
