package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class IdentityTypeUnitTest {

    @Test
    public void aTypeShouldHaveAName() throws Exception {
        PowerMockito.mockStatic(Log.class);

        IdentityType type = IdentityType.Facebook;

        assertEquals("facebook", type.toString());
    }

    //ApiRequest request = new ApiRequest(new URL("https://openflashcardsapi.herokuapp.com/api/topics"), Identity2.getInstance().getToken(), ApiRequest.IdentityType.Facebook);

}