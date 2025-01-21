package data_structures.queues.medium;

import java.util.*;

public class DesignTwitter_355 {

    private int count;
    private final Map<Integer, List<int[]>> tweetMap;
    private final Map<Integer, Set<Integer>> followMap;

    public DesignTwitter_355() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size()-1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }
        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] current = minHeap.poll();
            res.add(current[1]);
            int index = current[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(current[2]).get(index-1);
                minHeap.offer(new int[]{tweet[0], tweet[1], current[2], index-1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }

    public static void main(String[] args) {
        DesignTwitter_355 twitter = new DesignTwitter_355();

        // User 1 posts tweets
        twitter.postTweet(1, 5); // User 1 posts tweet with id 5
        twitter.postTweet(1, 3); // User 1 posts tweet with id 3
        twitter.postTweet(1, 101); // User 1 posts tweet with id 101

        // User 2 posts tweets
        twitter.postTweet(2, 6); // User 2 posts tweet with id 6
        twitter.postTweet(2, 13); // User 2 posts tweet with id 13

        // User 1 follows User 2
        twitter.follow(1, 2); // User 1 follows User 2

        // User 2 posts more tweets
        twitter.postTweet(2, 12); // User 2 posts tweet with id 12
        twitter.postTweet(2, 9);  // User 2 posts tweet with id 9

        // Get the news feed for User 1 (should include tweets from both User 1 and User 2)
        List<Integer> feed = twitter.getNewsFeed(1);
        System.out.println("User 1's news feed: " + feed);

        // User 1 unfollows User 2
        twitter.unfollow(1, 2); // User 1 unfollows User 2

        // Get the news feed for User 1 again (should only show User 1's tweets now)
        feed = twitter.getNewsFeed(1);
        System.out.println("User 1's news feed after unfollow: " + feed);
    }

}
