package com.gmail.michelegozzi.flashcards;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mgozzi on 10/3/2016.
 */

public class Topic extends HashMap<String, Question> {

    private String id;
    private String name;
    private String description;
    //private HashMap<String, Question> questions;
    //private List<String> keys;
    private Question[] shuffledQuestions;

    SOList<Question> iterQuestions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Topic() {}

    public static Topic createTopic(JSONObject data) {


        Topic topic = new Topic();


        try {

            
            topic.setName(data.getString("name"));

            JSONObject idjo = data.getJSONObject("id");

            topic.setId(idjo.getString("$oid"));

            topic.setDescription(data.getString("description"));

            JSONArray qja = data.getJSONArray("questions");

            HashMap <String, Question> questions = new HashMap<String, Question>();
            for (int i=0; i < qja.length(); i++) {
                Question q = new Question(qja.getJSONObject(i));
                questions.put(q.getId(), q);
            }


            ArrayList<Question> shuffled = new ArrayList<Question>();

            List keys = new ArrayList(questions.keySet());
            Collections.shuffle(keys);
            for (Object o : keys) {
                // Access keys/values in a random order
                shuffled.add(questions.get(o));
            }

            topic.shuffledQuestions = shuffled.toArray(new Question[0]);
            topic.iterQuestions = new SOList<Question>(topic.shuffledQuestions);


            //topic.addshuffle(questions).elements();
            
            //Log.d("TOPIC", "id: " + this.getId());
            //Log.d("TOPIC", "name: " + this.getName());
            //Log.d("TOPIC", "description: " + this.getDescription());

            // "name":"US Citizenship Civic Test","id":{"$oid":"57f1e6cfbbde3f0003000000"},"description":"Civics (History and Government) Questions for the Naturalization Test"
        }
        catch (org.json.JSONException ex) {
            //Log.e("TOPIC", "Failure - JSONException", ex);
        }

        return topic;
    }

    public Question[] getShuffledQuestions() {
        return shuffledQuestions;
    }
}
