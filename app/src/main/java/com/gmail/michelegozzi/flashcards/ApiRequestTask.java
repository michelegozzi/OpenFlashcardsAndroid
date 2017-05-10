package com.gmail.michelegozzi.flashcards;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgozzi on 10/1/2016.
 */

public class ApiRequestTask extends AsyncTask<ApiRequest, Integer, Long> {

    private List<String> jsonResponses = new ArrayList<String>();

    public String getJSONResponse(int index) {
        return jsonResponses.get(index);
    }
//    WeakReference<Activity> mWeakActivity;

//    public ApiRequestTask(Activity activity) {
////        mWeakActivity = new WeakReference<Activity>(activity);
//
//    }

    OnTaskCompleted listener;

    public ApiRequestTask(OnTaskCompleted listener) {
        this.listener = listener;
    }




    protected Long doInBackground(ApiRequest... requests) {
        long totalSize = 0;

        int count = requests.length;

        for (int i = 0; i < count; i++) {

            try {
                //URL url = new URL("https://wikipedia.org");
                //URL url = new URL("https://openflashcardsapi.herokuapp.com/api/v1/questions");

                JSONObject req = new JSONObject();


                try {
                    req.put("api_token", requests[i].getToken());
                    //req.put("api_token", MainActivity.gFbAccessToken.getToken());
                    Log.d("TOPIC", req.toString());
                } catch (org.json.JSONException ex) {
                    Log.e("TOPIC", "Failure", ex);
                }

                HttpURLConnection urlConnection = (HttpURLConnection) requests[i].getUrl().openConnection();

                try {
                    urlConnection.setRequestMethod("GET");
                    //urlConnection.setDoOutput(true);
                    urlConnection.setDoInput(true);
                    //urlConnection.setChunkedStreamingMode(0);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Authorization", "Bearer " + requests[i].getToken());  //MainActivity.gFbAccessToken.getToken());
                    urlConnection.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                    urlConnection.setRequestProperty("Pragma", "no-cache"); // HTTP 1.0.
                    urlConnection.setRequestProperty("Expires", "0"); // Proxies.
                    urlConnection.setRequestProperty("Accept", "application/openflashcards." + requests[i].getIdentityType().toString() + ".v1");
//                    DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
//                    out.writeBytes(URLEncoder.encode(req.toString(), "UTF-8"));
//                    out.flush();
//                    out.close();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    String response = readStream(in);
                    Log.d("TOPIC", "Response: " + response);

//                    try {
//                        this.jsonResponse = new JSONObject(response);
//                    }
//                    catch (org.json.JSONException ex) {
//                        Log.e("TOPIC", "Failure - JSONException", ex);
//                    }

                    totalSize += response.length();

                    this.jsonResponses.add(response);

                    in.close();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (IOException ex) {
                Log.e("TOPIC", "Failure - IOException", ex);
            }
        }

        publishProgress(100);

        return totalSize;
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        Log.i("DOWNLOAD", "Downloaded " + result + " bytes.");

        for (int i=0; i< this.jsonResponses.size(); i++)
        listener.onTaskCompleted(this.getJSONResponse(i));

//        Activity activity = mWeakActivity.get();
//        if (activity != null) {
//            //int id = activity.findViewById(...);
//            ((TopicActivity)activity).setQuestions(this.getJSONResponse());
//        }
    }

    private String readStream(InputStream inputStream) {
        String result = null;
        try {
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            final StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(inputStream, "UTF-8");
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            result = out.toString();
        }
        catch (java.io.UnsupportedEncodingException ex) {
            Log.e("TOPIC", "Failure in readStream", ex);
        }
        catch (java.io.IOException ex) {
            Log.e("TOPIC", "Failure in readStream", ex);
        }
        finally {
            return result;
        }
    }
}
