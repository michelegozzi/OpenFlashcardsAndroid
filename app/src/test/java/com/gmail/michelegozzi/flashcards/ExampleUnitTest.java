package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class ExampleUnitTest {

    @Test
    public void aTopicShouldAName() throws Exception {
        PowerMockito.mockStatic(Log.class);

        String data = "[{\"name\":\"US Citizenship Civic Test\",\"id\":{\"$oid\":\"57f32bafaaf85f3848000000\"},\"description\":\"Civics (History and Government) Questions for the Naturalization Test\",\"questions\":[{\"text\":\"What is the supreme law of the land?\",\"id\":{\"$oid\":\"57f32bafaaf85f3848000001\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bafaaf85f3848000002\"},\"created_at\":\"2016-10-04T04:10:23.941Z\",\"question_id\":{\"$oid\":\"57f32bafaaf85f3848000001\"},\"text\":\"the Constitution\",\"updated_at\":\"2016-10-04T04:10:23.979Z\"}]},{\"text\":\"What does the Constitution do?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000004\"},\"created_at\":\"2016-10-04T04:10:24.086Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"sets up the government\",\"updated_at\":\"2016-10-04T04:10:24.164Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000005\"},\"created_at\":\"2016-10-04T04:10:24.113Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"defines the government\",\"updated_at\":\"2016-10-04T04:10:24.190Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000006\"},\"created_at\":\"2016-10-04T04:10:24.138Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"protects basic rights of Americans\",\"updated_at\":\"2016-10-04T04:10:24.218Z\"}]},{\"text\":\"The idea of self-government is in the first three words of the Constitution. What are these words?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000007\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000008\"},\"created_at\":\"2016-10-04T04:10:24.271Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000007\"},\"text\":\"We the People\",\"updated_at\":\"2016-10-04T04:10:24.296Z\"}]},{\"text\":\"What is an amendment?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000a\"},\"created_at\":\"2016-10-04T04:10:24.376Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"text\":\"a change (to the Constitution)\",\"updated_at\":\"2016-10-04T04:10:24.439Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000b\"},\"created_at\":\"2016-10-04T04:10:24.402Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"text\":\"an addition (to the Constitution)\",\"updated_at\":\"2016-10-04T04:10:24.465Z\"}]},{\"text\":\"What do we call the first ten amendments to the Constitution?\",\"id\":{\"$oid\":\"57f32bb0aaf85f384800000c\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000d\"},\"created_at\":\"2016-10-04T04:10:24.546Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000c\"},\"text\":\"the Bill of Rights\",\"updated_at\":\"2016-10-04T04:10:24.570Z\"}]},{\"text\":\"What is one right or freedom from the First Amendment?\",\"id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000f\"},\"created_at\":\"2016-10-04T04:10:24.657Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"speech\",\"updated_at\":\"2016-10-04T04:10:24.780Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000010\"},\"created_at\":\"2016-10-04T04:10:24.681Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"religion\",\"updated_at\":\"2016-10-04T04:10:24.807Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000011\"},\"created_at\":\"2016-10-04T04:10:24.705Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"assembly\",\"updated_at\":\"2016-10-04T04:10:24.833Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000012\"},\"created_at\":\"2016-10-04T04:10:24.729Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"press\",\"updated_at\":\"2016-10-04T04:10:24.860Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000013\"},\"created_at\":\"2016-10-04T04:10:24.755Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"petition the government\",\"updated_at\":\"2016-10-04T04:10:24.885Z\"}]},{\"text\":\"How many amendments does the Constitution have?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000014\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000015\"},\"created_at\":\"2016-10-04T04:10:24.964Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000014\"},\"text\":\"twenty-seven (27)\",\"updated_at\":\"2016-10-04T04:10:24.989Z\"}]}]}]";

        try {

            JSONArray obj = new JSONArray(data);

            assertEquals(1, obj.length());

            Topic topic = Topic.createTopic(obj.getJSONObject(0));

            //String name = obj.getString("name");

            Log.d("TEST", "name: " + topic.getName());
            assertEquals("57f32bafaaf85f3848000000", topic.getId());
            assertEquals("US Citizenship Civic Test", topic.getName());

            assertEquals("Civics (History and Government) Questions for the Naturalization Test", topic.getDescription());
            //obj.keys();

//            while (topic.questions.iterator().hasNext())
//            {
//                Question q = topic.questions.iterator().next();
//            }

            //Iterator x = obj.keys();
            //JSONArray jsonArray = new JSONArray();

            //while (x.hasNext()){
            //    String key = (String) x.next();
                //jsonArray.put(obj.get(key));
            //}
        }
        catch (org.json.JSONException ex) {
            //Log.e("TOPIC", "Failure - JSONException", ex);
            assertNull(ex.getMessage(), ex);
        }

        //assertEquals(4, 2 + 2);
    }

    @Test
    public void topicShouldReturShuffledElements() throws Exception {
        PowerMockito.mockStatic(Log.class);

        String data = "[{\"name\":\"US Citizenship Civic Test\",\"id\":{\"$oid\":\"57f32bafaaf85f3848000000\"},\"description\":\"Civics (History and Government) Questions for the Naturalization Test\",\"questions\":[{\"text\":\"What is the supreme law of the land?\",\"id\":{\"$oid\":\"57f32bafaaf85f3848000001\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bafaaf85f3848000002\"},\"created_at\":\"2016-10-04T04:10:23.941Z\",\"question_id\":{\"$oid\":\"57f32bafaaf85f3848000001\"},\"text\":\"the Constitution\",\"updated_at\":\"2016-10-04T04:10:23.979Z\"}]},{\"text\":\"What does the Constitution do?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000004\"},\"created_at\":\"2016-10-04T04:10:24.086Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"sets up the government\",\"updated_at\":\"2016-10-04T04:10:24.164Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000005\"},\"created_at\":\"2016-10-04T04:10:24.113Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"defines the government\",\"updated_at\":\"2016-10-04T04:10:24.190Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000006\"},\"created_at\":\"2016-10-04T04:10:24.138Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000003\"},\"text\":\"protects basic rights of Americans\",\"updated_at\":\"2016-10-04T04:10:24.218Z\"}]},{\"text\":\"The idea of self-government is in the first three words of the Constitution. What are these words?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000007\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000008\"},\"created_at\":\"2016-10-04T04:10:24.271Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000007\"},\"text\":\"We the People\",\"updated_at\":\"2016-10-04T04:10:24.296Z\"}]},{\"text\":\"What is an amendment?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000a\"},\"created_at\":\"2016-10-04T04:10:24.376Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"text\":\"a change (to the Constitution)\",\"updated_at\":\"2016-10-04T04:10:24.439Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000b\"},\"created_at\":\"2016-10-04T04:10:24.402Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000009\"},\"text\":\"an addition (to the Constitution)\",\"updated_at\":\"2016-10-04T04:10:24.465Z\"}]},{\"text\":\"What do we call the first ten amendments to the Constitution?\",\"id\":{\"$oid\":\"57f32bb0aaf85f384800000c\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000d\"},\"created_at\":\"2016-10-04T04:10:24.546Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000c\"},\"text\":\"the Bill of Rights\",\"updated_at\":\"2016-10-04T04:10:24.570Z\"}]},{\"text\":\"What is one right or freedom from the First Amendment?\",\"id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f384800000f\"},\"created_at\":\"2016-10-04T04:10:24.657Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"speech\",\"updated_at\":\"2016-10-04T04:10:24.780Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000010\"},\"created_at\":\"2016-10-04T04:10:24.681Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"religion\",\"updated_at\":\"2016-10-04T04:10:24.807Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000011\"},\"created_at\":\"2016-10-04T04:10:24.705Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"assembly\",\"updated_at\":\"2016-10-04T04:10:24.833Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000012\"},\"created_at\":\"2016-10-04T04:10:24.729Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"press\",\"updated_at\":\"2016-10-04T04:10:24.860Z\"},{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000013\"},\"created_at\":\"2016-10-04T04:10:24.755Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f384800000e\"},\"text\":\"petition the government\",\"updated_at\":\"2016-10-04T04:10:24.885Z\"}]},{\"text\":\"How many amendments does the Constitution have?\",\"id\":{\"$oid\":\"57f32bb0aaf85f3848000014\"},\"answers\":[{\"_id\":{\"$oid\":\"57f32bb0aaf85f3848000015\"},\"created_at\":\"2016-10-04T04:10:24.964Z\",\"question_id\":{\"$oid\":\"57f32bb0aaf85f3848000014\"},\"text\":\"twenty-seven (27)\",\"updated_at\":\"2016-10-04T04:10:24.989Z\"}]}]}]";

        try {

            JSONArray obj = new JSONArray(data);

            assertEquals(1, obj.length());

            Topic topic1 = Topic.createTopic(obj.getJSONObject(0));
            Topic topic2 = Topic.createTopic(obj.getJSONObject(0));

            if (topic1.iterQuestions.iterator().hasNext() && topic2.iterQuestions.iterator().hasNext())
            {
                Question q1 = topic1.iterQuestions.iterator().next();
                Question q2 = topic2.iterQuestions.iterator().next();

                assertNotEquals(q1.getId(), q2.getId());
            }


        }
        catch (org.json.JSONException ex) {
            //Log.e("TOPIC", "Failure - JSONException", ex);
            assertNull(ex.getMessage(), ex);
        }

        //assertEquals(4, 2 + 2);
    }
}