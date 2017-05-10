package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class TopicsUnitTest {

    @Test
    public void aTopicShouldAName() throws Exception {
        PowerMockito.mockStatic(Log.class);

        String data = "[{\"name\":\"US Citizenship Civic Test\",\"id\":{\"$oid\":\"57f54e1a9a158d0003000000\"},\"description\":\"Civics (History and Government) Questions for the Naturalization Test\"}]";

        try {

            JSONArray arr = new JSONArray(data);

            assertEquals(1, arr.length());

            Topic topic = Topic.createTopic(arr.getJSONObject(0));

            //String name = obj.getString("name");

            Log.d("TEST", "name: " + topic.getName());
            assertEquals("57f54e1a9a158d0003000000", topic.getId());
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


}