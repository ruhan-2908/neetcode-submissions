class Twitter {
    HashMap<Integer,HashSet<Integer>> followMap;
    HashMap<Integer,List<int[]>> tweetMap;
    int count;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k-> new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        followMap.computeIfAbsent(userId,k-> new HashSet<>()).add(userId);

        for(int following : followMap.get(userId))
        {
            if(tweetMap.containsKey(following))
            {
                List<int[]> tweets = tweetMap.get(following);
                int length = tweets.size() - 1;
                int[] tweet = tweets.get(length);
                int recency = tweet[0];
                int tweetId = tweet[1];
                minHeap.offer(new int[]{recency,tweetId,following,length});
            }
        }

        while(!minHeap.isEmpty() && ans.size() < 10)
        {
            int[] temp = minHeap.poll();
            ans.add(temp[1]);
            int length = temp[3];
            if(length > 0)
            {
                int[] tweet = tweetMap.get(temp[2]).get(length-1);
                length--;
                minHeap.offer(new int[]{tweet[0],tweet[1],temp[2],length});
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId,(k,v)->{
            v.remove(followeeId);
            return v;
        });
    }
}
