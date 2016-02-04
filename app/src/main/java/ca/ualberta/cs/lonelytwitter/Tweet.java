package ca.ualberta.cs.lonelytwitter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * A Tweet contains the body of a Tweet as a String <code>message</code>
 * of less than 140 chars, and the date of the Tweet as <code>date</code>.
 * @see NormalTweet
 * @see ImportantTweet
 * @see TweetList
 *
 */
public abstract class Tweet implements Comparable<Tweet>{
    protected String message;
    protected Date date;

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    /**
     *
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    abstract public boolean isImportant();

    public int compareTo(Tweet other) {
        return date.compareTo(other.getDate());
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
