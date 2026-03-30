class Twitter {
    private int count;
    private HashMap<Integer,List<int[]>> tweetMap;
    private HashMap<Integer,Set<Integer>> followMap;
    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int tempId : followMap.get(userId))
        {
            if(tweetMap.containsKey(tempId))
            {
                List<int[]> tweets = tweetMap.get(tempId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0],tweet[1],tempId,index});
            }
        }

        while(!minHeap.isEmpty() && res.size() < 10)
        {
            int[] tweet = minHeap.poll();
            res.add(tweet[1]);
            int length = tweet[3];
            if(length > 0)
            {
                int[] tempTweet = tweetMap.get(tweet[2]).get(length-1);
                minHeap.offer(new int[]{tempTweet[0],tempTweet[1],tweet[2],length-1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k,v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
