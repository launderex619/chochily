package com.carcavaz.chochilyapp.requests;

import android.os.AsyncTask;
import android.util.Log;

import com.carcavaz.chochilyapp.constant.ConstantValues;
import com.carcavaz.chochilyapp.constant.Helper;
import com.carcavaz.chochilyapp.fragments.PersonalFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class getAllPersonalAsync extends AsyncTask<String, Void, String> {
    public  Helper helper = new Helper();
    public  QueryTaskListener mListener;

    public interface QueryTaskListener
    {
        public void onQueryStart();
        public void onQueryFinish(String res);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mListener != null){
            mListener.onQueryStart();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        String response = null;
        String sUrl = ConstantValues.URL_BASE + "personal/";
        try {
            URL url = new URL(sUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            response = helper.ConvertInputStreamToString(urlConnection.getInputStream());
            urlConnection.disconnect();

        }catch (IOException e) {
            return null;
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mListener != null){
            mListener.onQueryFinish(result);
        }
    }
}
