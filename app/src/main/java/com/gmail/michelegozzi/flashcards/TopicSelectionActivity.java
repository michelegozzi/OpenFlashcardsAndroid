package com.gmail.michelegozzi.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TopicSelectionActivity extends AppCompatActivity {

    public final static String SELECTED_TOPIC = "SELECTED_TOPIC";
    ListView listView;
    private ArrayList<Topic> topics = new ArrayList<Topic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

        listView = (ListView)findViewById(R.id.topics);

        try {
            ApiRequest request = new ApiRequest(new URL("https://openflashcardsapi.herokuapp.com/api/topics"), Identity2.getInstance().getToken(), Identity2.getInstance().getIdentityType());

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1);

            new ApiRequestTask(new OnTaskCompleted() {
                @Override
                public void onTaskCompleted(String data) {
                    try {
                        JSONArray obj = new JSONArray(data);
                        for (int i = 0; i < obj.length(); i++) {
                            Topic topic = Topic.createTopic(obj.getJSONObject(i));

                            topics.add(topic);
                            adapter.add(topic.getName());
                        }
                    }
                    catch (JSONException ex) {
                        Log.e("TOPIC", "Failure on get JSON array", ex);
                    }
                }
            }).execute(request);
            //task.
            listView.setAdapter(adapter);

            // ListView on item selected listener.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    Topic topic = topics.get(position);

                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra(SELECTED_TOPIC, topic.getId());
                    startActivity(intent);
                }
            });


        }
        catch (MalformedURLException ex) {
            Log.e("TOPIC", "Failure - MalformedURLException", ex);
        }


    }
}
