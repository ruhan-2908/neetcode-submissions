class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] home = new double[position.length][2];
        for(int i = 0 ; i < position.length ; i++)
        {
            home[i][0] = position[i];
            home[i][1] = ((double) target - position[i]) / speed[i];
        }
        int fleets = 0;
        double time = 0;
        Arrays.sort(home,(a,b) -> Double.compare(b[0],a[0]));
        for(double[] h : home)
        {
            if(h[1] > time)
            {
                fleets++;
                time = h[1];
            }
        }
        return fleets;
    }
}
