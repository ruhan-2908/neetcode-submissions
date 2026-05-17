class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int ans = 0;
        while(i<j)
        {
            int tot = people[i] + people[j];
            if(tot <= limit) i++;
            j--;
            ans++;
        }
        if(i==j) ans++;
        return ans;
    }
}