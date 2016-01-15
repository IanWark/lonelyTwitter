package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by wark on 1/14/16.
 */
public abstract class Tweet {
    protected String message;
    private Date date;
    private List<Mood> Moodlist;


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

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood[] getMoodlist() {
        return Moodlist;
    }

    public void setMoodlist(Mood[] moodlist) {
        Moodlist = moodlist;
    }

    abstract public boolean isImportant();
}
