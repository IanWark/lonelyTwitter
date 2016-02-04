package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Holds a list of Tweets. <br>
 *     Contained in LonelyTwitterActivity
 * @see LonelyTwitterActivity
 * @see Tweet
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Adds a non-duplicate tweet to the list
     * @param tweet
     * @exception IllegalArgumentException
     */
    public void addTweet(Tweet tweet){
        if (this.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    /**
     * Checks if specific tweet is in the list
     * @param tweet
     * @return Boolean
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * removes a specific tweet from the list
     * @param tweet
     */
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * returns a list of the tweets in chronological order
     * @return ArrayList<Tweet>
     */
    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> returnedArray = new ArrayList<Tweet>(tweets);
        Collections.sort(returnedArray);
        return returnedArray;
    }

    /**
     * Returns number of tweets
     * @return int
     */
    public int getCount(){
        return tweets.size();
    }

}
