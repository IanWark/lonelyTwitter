package ca.ualberta.cs.lonelytwitter;

/**
 * Created by wark on 1/14/16.
 */
public class NormalTweet extends Tweet implements Tweetable{
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
