package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mgozzi on 10/3/2016.
 */

public class Answer {
    private String id;
    private String text;

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

    public Answer(JSONObject data) {

        try {

            this.setText(data.getString("text"));

            JSONObject idjo = data.getJSONObject("_id");

            this.setId(idjo.getString("$oid"));

            Log.d("ANSWER", "id: " + this.getId());
            Log.d("ANSWER", "text: " + this.getText());

            // "name":"US Citizenship Civic Test","id":{"$oid":"57f1e6cfbbde3f0003000000"},"description":"Civics (History and Government) Questions for the Naturalization Test"
        }
        catch (org.json.JSONException ex) {
            //Log.e("TOPIC", "Failure - JSONException", ex);
        }
    }
}
