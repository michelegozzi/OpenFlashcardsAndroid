package com.gmail.michelegozzi.flashcards;

import com.google.firebase.database.PropertyName;

import java.net.URL;

/**
 * Created by mgozzi on 10/28/2016.
 */

public class ApiRequest {




    private URL url;
    private String token;
    private IdentityType identityType;


    public ApiRequest (URL url, String  token)  {
        this(url, token, IdentityType.Api);
    }

    public ApiRequest (URL url, String  token, IdentityType identityType) {
        this.setUrl(url);
        this.setToken(token);
        this.setIdentityType(identityType);
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IdentityType getIdentityType() {
        return this.identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }
}
