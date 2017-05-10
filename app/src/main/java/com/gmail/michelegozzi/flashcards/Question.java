package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mgozzi on 10/3/2016.
 */

public class Question {
    private String id;
    private String text;
    private HashMap<String, Answer> answers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Question(JSONObject data) {

        try {

            this.setText(data.getString("text"));

            JSONObject idjo = data.getJSONObject("id");

            this.setId(idjo.getString("$oid"));

            Log.d("QUESTION", "id: " + this.getId());
            Log.d("QUESTION", "text: " + this.getText());

            this.answers = new HashMap<String, Answer>();

            JSONArray aja = data.getJSONArray("answers");

            for (int i=0; i < aja.length(); i++) {
                Answer a = new Answer(aja.getJSONObject(i));
                this.answers.put(a.getId(), a);
            }

            // "name":"US Citizenship Civic Test","id":{"$oid":"57f1e6cfbbde3f0003000000"},"description":"Civics (History and Government) Questions for the Naturalization Test"
        }
        catch (org.json.JSONException ex) {
            //Log.e("TOPIC", "Failure - JSONException", ex);
        }
    }


    public List<Answer> getAnswers() {
        return new ArrayList<Answer>(answers.values());
    }


}
