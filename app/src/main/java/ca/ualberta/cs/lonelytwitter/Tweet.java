package ca.ualberta.cs.lonelytwitter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wark on 1/14/16.
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
