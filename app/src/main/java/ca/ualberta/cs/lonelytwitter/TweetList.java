package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created by wark on 1/28/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        if (this.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }


    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> returnedArray = new ArrayList<Tweet>(tweets);
        Collections.sort(returnedArray);
        return returnedArray;
    }

    public int getCount(){
        return tweets.size();
    }

}
