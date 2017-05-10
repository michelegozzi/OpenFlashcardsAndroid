package com.gmail.michelegozzi.flashcards;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.facebook.FacebookSdk;
//import com.google.android.gms.appdatasearch.GetRecentContextCall;
//
//import android.os.AsyncTask;
//import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


public class TopicActivity extends AppCompatActivity  {
//    implements OnTaskCompleted

    TextView questionTextView;
    ListView answersListView;
    Button buttonShow;
    Button buttonNext;
    Button buttonPrev;
    private Topic topic;
    int current;
    ProgressDialog progress;
    //Iterator<Question> questionIterator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progress = new ProgressDialog(this);
        progress.setMessage("Downloading topic...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        setContentView(R.layout.activity_topic);

        questionTextView = (TextView) findViewById(R.id.question);
        answersListView = (ListView)findViewById(R.id.answers);
        buttonShow = (Button) findViewById(R.id.buttonShow);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button) findViewById(R.id.buttonPrev);

        Intent intent = getIntent();
        String topicId = intent.getStringExtra(TopicSelectionActivity.SELECTED_TOPIC);

        try {
            ApiRequest request = new ApiRequest(new URL("https://openflashcardsapi.herokuapp.com/api/topics/"+topicId), Identity2.getInstance().getToken(), Identity2.getInstance().getIdentityType());

            new ApiRequestTask(new OnTaskCompleted() {
                @Override
                public void onTaskCompleted(String data) {
                    try {
                        JSONObject obj = new JSONObject(data);
                        topic = Topic.createTopic(obj);

                        //questionIterator = topic.questions.iterator();
                        current = -1;
                        onNext();
                        progress.hide();
                    }
                    catch (JSONException ex) {
                        Log.e("TOPIC", "Failure on get JSON array", ex);
                    }
                }
            }).execute(request);
            //task.
        }
        catch (MalformedURLException ex) {
            Log.e("TOPIC", "Failure - MalformedURLException", ex);
        }
    }

    /** Called when the user clicks the Send button */
    public void onClickShow(View view) {
        buttonShow.setEnabled(false);
        answersListView.setVisibility(View.VISIBLE);
    }

    private void onNext() {
        //if (this.questionIterator.hasNext())
        current++;
        showCurrent();
    }

    private void onPrev() {
        //if (this.questionIterator.hasNext())
        current--;
        showCurrent();
    }

    private void showCurrent() {

        buttonPrev.setEnabled(current > 0);
        buttonNext.setEnabled(current < (topic.getShuffledQuestions().length - 1));

        if (current >= 0 && current < topic.getShuffledQuestions().length)
        {
            setTitle(getResources().getText(R.string.app_name) + " ("+(current+1)+"/"+topic.getShuffledQuestions().length+")");
            Question q = topic.getShuffledQuestions()[current]; //this.questionIterator.next();

            questionTextView.setText(q.getText());

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1);
            for( Answer answer : q.getAnswers() ) {
                adapter.add(answer.getText());
            }
            answersListView.setAdapter(adapter);
            answersListView.setVisibility(View.INVISIBLE);

            buttonShow.setEnabled(true);
            //String message = loginResult.
            //intent.putExtra(EXTRA_MESSAGE, message);
        }
    }


    public void onClickNext(View view) {
        onNext();
    }

    public void onClickPrev(View view) {
        onPrev();
    }
}
