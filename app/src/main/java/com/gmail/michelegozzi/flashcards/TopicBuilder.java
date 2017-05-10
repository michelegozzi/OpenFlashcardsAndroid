package com.gmail.michelegozzi.flashcards;

import org.json.JSONObject;

public class TopicBuilder {
    private JSONObject data;

    public TopicBuilder setData(JSONObject data) {
        this.data = data;
        return this;
    }

    public Topic createTopic() {
        return Topic.createTopic(data);
    }
}