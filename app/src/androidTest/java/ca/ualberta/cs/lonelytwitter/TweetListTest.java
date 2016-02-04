package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test TweetList methods
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try{
            tweets.addTweet(tweet);
        } catch (IllegalArgumentException e) {
            return; }
        fail();
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testRemoveTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("A Third Test Tweet");

        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.removeTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Date date1 = new Date(1000);
        Date date2 = new Date(2000);
        Date date3 = new Date(3000);
        Tweet tweet1 = new NormalTweet("Test Tweet 1",date1);
        Tweet tweet2 = new NormalTweet("Test Tweet 2",date2);
        Tweet tweet3 = new NormalTweet("Test Tweet 3",date3);

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);
        ArrayList<Tweet> tweetArray = new ArrayList<Tweet>();
        tweetArray.add(0,tweet1);
        tweetArray.add(1,tweet2);
        tweetArray.add(2,tweet3);
        assertEquals(tweetArray, tweets.getTweets());
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Test Tweet 1");
        Tweet tweet2 = new NormalTweet("Test Tweet 2");
        Tweet tweet3 = new NormalTweet("Test Tweet 3");

        tweets.addTweet(tweet1);
        assertEquals(1, tweets.getCount());
        tweets.addTweet(tweet2);
        assertEquals(2, tweets.getCount());
        tweets.addTweet(tweet3);
        assertEquals(3,tweets.getCount());
    }
}