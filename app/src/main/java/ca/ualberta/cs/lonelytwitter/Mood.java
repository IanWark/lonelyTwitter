package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by wark on 1/14/16.
 */
public abstract class Mood {
    protected Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
