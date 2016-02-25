package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;


    public static class GetTweetTask extends AsyncTask<String,Void,ArrayList<NormalTweet>>{

        @Override
        protected ArrayList<NormalTweet> doInBackground(String... strings){
            verifyConfig();
            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

            // NOTE: A HUGE ASSUMPTION
            // Assume that only one string is passed in.
            String search_string = strings[0];
            if (search_string != ""){
                search_string = "{\"query\":{\"match\":{\"message\":\"" + search_string + "\"}}}";
            }

            Search search = new Search.Builder(search_string).addIndex("testing").addType("tweet").build();
            try{
                SearchResult execute = client.execute(search);
                if (execute.isSucceeded()) {
                    List<NormalTweet> foundTweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(foundTweets);
                } else {
                    Log.i("TODO", "Search was unsuccessful");
                }
            } catch (IOException e){
                e.printStackTrace();
            }

            return tweets;
        }

    }

    public static class AddTweetTask extends AsyncTask<NormalTweet,Void,Void>{

        @Override
        protected Void doInBackground(NormalTweet... tweets) {
            verifyConfig();

            for(NormalTweet tweet : tweets) {
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult execute = client.execute(index);
                    if (execute.isSucceeded()) {
                        tweet.setId(execute.getId());
                    } else {
                        Log.e("TODO", "Insert of tweet failed");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    // If no client, add one
    public static void verifyConfig(){
        if(client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}
