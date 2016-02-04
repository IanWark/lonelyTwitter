package ca.ualberta.cs.lonelytwitter;

/**
 * @see Tweet
 */
public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(String message) {
        super(message);
    }

    public String getMessage() {
        return "IMPORTANT: "+this.message;
    }

    @Override
    public boolean isImportant() {
        return true;
    }
}
