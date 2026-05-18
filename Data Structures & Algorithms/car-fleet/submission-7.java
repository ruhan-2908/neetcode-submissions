class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] home = new double[position.length][2];
        for(int i = 0 ; i < position.length ; i++)
        {
            home[i][0] = position[i];
            home[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(home,(a,b) -> Double.compare(b[0],a[0]));
        int count = 0 ;
        double prevTime = 0;
        for(double[] d : home)
        {
            if(d[1] > prevTime)
            {
                count++;
                prevTime = d[1];
            }
        }
        return count;
    }
}
