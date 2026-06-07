class Twitter {
    HashMap<Integer,HashSet<Integer>> followMap;
    HashMap<Integer,List<int[]>> tweetMap;
    int count;
    public Twitter() {
        this.count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k -> new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        followMap.computeIfAbsent(userId,k-> new HashSet<>()).add(userId);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int following : followMap.get(userId))
        {
            if(tweetMap.containsKey(following))
            {
                List<int[]> tweetsOfHim = tweetMap.get(following);
                int length = tweetsOfHim.size() - 1;
                int[] tweetOfHim = tweetsOfHim.get(length);
                minHeap.offer(new int[]{tweetOfHim[0],tweetOfHim[1],following,length});
            }
        }

        while(!minHeap.isEmpty() && res.size() < 10)
        {
            int[] curr = minHeap.poll();
            int length = curr[3];
            res.add(curr[1]);
            if(length > 0)
            {
                int[] anotherTweet = tweetMap.get(curr[2]).get(length-1);
                length--;
                minHeap.offer(new int[]{anotherTweet[0],anotherTweet[1],curr[2],length});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId,(k,v) ->{
            v.remove(followeeId);
            return v;
        });
    }
}
