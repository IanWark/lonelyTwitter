package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @see Tweet
 */
public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet(String message, Date date) {
        super(message);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
