package com.gmail.michelegozzi.flashcards;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.gmail.michelegozzi.flashcards.database.AppDbHelper;
import com.gmail.michelegozzi.flashcards.database.IdentityContract;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import android.database.sqlite;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //private LoginButton mFbLoginButton;

    public static AccessToken gFbAccessToken;
    //AccessToken accessToken;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.gmail.michelegozzi.flashcards",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        Identity2.getInstance().load(getApplicationContext());
        if (Identity2.getInstance().hasValidToken()) {
            Log.d("MAIN", "a valid identity exists.");
            Intent goToNextActivity = new Intent(getApplicationContext(), TopicSelectionActivity.class);
            startActivity(goToNextActivity);
        }
        else {

            callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {

                            gFbAccessToken = loginResult.getAccessToken();

                            Log.d("MAIN", "onSuccess");

                            //Intent goToNextActivity = new Intent(getApplicationContext(), TopicActivity.class);
                            Intent goToNextActivity = new Intent(getApplicationContext(), TopicSelectionActivity.class);

                            //EditText editText = (EditText) findViewById(R.id.edit_message);
                            //String message = loginResult.
                            //intent.putExtra(EXTRA_MESSAGE, message);
                            Identity2.getInstance().setUserId(gFbAccessToken.getUserId());
                            Identity2.getInstance().setApplicationId(gFbAccessToken.getApplicationId());
                            Identity2.getInstance().setToken(gFbAccessToken.getToken());
                            Identity2.getInstance().setIdentityType(IdentityType.Facebook);
                            Identity2.getInstance().save(getApplicationContext());

                            startActivity(goToNextActivity);
                        }

                        @Override
                        public void onCancel() {
                            // App code
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                        }
                    });

            gFbAccessToken = AccessToken.getCurrentAccessToken();

            if (gFbAccessToken != null) {
                Log.d("MAIN", "Token: " + gFbAccessToken.getToken());
                Log.d("MAIN", "User ID: " + gFbAccessToken.getUserId());
                Log.d("MAIN", "App ID: " + gFbAccessToken.getApplicationId());
                Log.d("MAIN", "access token already present");

                Identity2.getInstance().setUserId(gFbAccessToken.getUserId());
                Identity2.getInstance().setApplicationId(gFbAccessToken.getApplicationId());
                Identity2.getInstance().setToken(gFbAccessToken.getToken());
                Identity2.getInstance().save(getApplicationContext());

                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("MAIN", "onActivityResult");

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void readIdentityFromDb() {

    }



    public void emailLogin(View view) {
        Intent emailLoginIntent = new Intent(this, EmailLoginActivity.class);
        startActivity(emailLoginIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.main_menu_mi_update:

                return true;
            case R.id.main_menu_mi_info:
                //showInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
