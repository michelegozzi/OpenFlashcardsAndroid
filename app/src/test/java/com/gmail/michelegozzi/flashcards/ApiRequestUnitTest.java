package com.gmail.michelegozzi.flashcards;

import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class ApiRequestUnitTest {

    @Test
    public void aTopicShouldAName() throws Exception {
        PowerMockito.mockStatic(Log.class);

        IdentityType type = IdentityType.Facebook;
        ApiRequest request = new ApiRequest(new URL("https://openflashcardsapi.herokuapp.com/api/topics"), "mytokenXYZ", type);

        assertEquals("mytokenXYZ", request.getToken());
        assertEquals(new URL("https://openflashcardsapi.herokuapp.com/api/topics"), request.getUrl());
        assertEquals(IdentityType.Facebook, request.getIdentityType());
        assertEquals("facebook", request.getIdentityType().toString());
    }

    //

}