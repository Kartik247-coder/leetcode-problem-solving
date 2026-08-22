class Twitter {
    class Pair {
        int userId;
        int tweetId;
        int time;

        Pair(int userId, int tweetId, int time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    HashMap<Integer, HashSet<Integer>> following;
    HashMap<Integer, HashSet<Integer>> followers;
    HashMap<Integer, ArrayDeque<Pair>> feed;

    int time = 0;

    public Twitter() {
        following = new HashMap<>();
        followers = new HashMap<>();
        feed = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        if (!feed.containsKey(userId)) {
            feed.put(userId, new ArrayDeque<>());
        }

        Pair p = new Pair(userId, tweetId, time++);

        feed.get(userId).offerLast(p);

        if (!followers.containsKey(userId)) return;

        for (int user : followers.get(userId)) {

            if (!feed.containsKey(user)) {
                feed.put(user, new ArrayDeque<>());
            }

            feed.get(user).offerLast(
                new Pair(userId, tweetId, p.time)
            );
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        if (!feed.containsKey(userId))
            return ans;

        ArrayDeque<Pair> news = feed.get(userId);
        Stack<Pair> st = new Stack<>();

        int count = 0;

        while (!news.isEmpty() && count < 10) {

            Pair p = news.pollLast();

            ans.add(p.tweetId);
            st.push(p);

            count++;
        }

        while (!st.isEmpty()) {
            news.offer(st.pop());
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }

        if (!followers.containsKey(followeeId)) {
            followers.put(followeeId, new HashSet<>());
        }

        if (following.get(followerId).contains(followeeId))
            return;

        following.get(followerId).add(followeeId);
        followers.get(followeeId).add(followerId);

        if (!feed.containsKey(followeeId))
            return;

        if (!feed.containsKey(followerId)) {
            feed.put(followerId, new ArrayDeque<>());
        }

        ArrayDeque<Pair> news = feed.get(followerId);
        ArrayDeque<Pair> temp = new ArrayDeque<>();

        // Put follower's current tweets into temp
        while (!news.isEmpty()) {
            temp.offer(news.poll());
        }

        // Add followee's tweets
        for (Pair p : feed.get(followeeId)) {
            if (p.userId == followeeId) {
                temp.offer(p);
            }
        }

        ArrayList<Pair> list = new ArrayList<>(temp);

        list.sort((a, b) -> Integer.compare(a.time, b.time));

        news.clear();

        for (Pair p : list) {
            news.offer(p);
        }
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }

        if (followers.containsKey(followeeId)) {
            followers.get(followeeId).remove(followerId);
        }

        if (!feed.containsKey(followerId))
            return;

        ArrayDeque<Pair> news = feed.get(followerId);
        Stack<Pair> st = new Stack<>();

        while (!news.isEmpty()) {

            Pair p = news.pollLast();

            if (p.userId != followeeId) {
                st.push(p);
            }
        }

        while (!st.isEmpty()) {
            news.offer(st.pop());
        }
    }
}