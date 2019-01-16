package com.carcavaz.chochilyapp.requests;

import android.os.AsyncTask;

import com.carcavaz.chochilyapp.constant.ConstantValues;
import com.carcavaz.chochilyapp.constant.Helper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class getProductionCategoriesAsync extends AsyncTask<String, Void, String> {
    public Helper helper = new Helper();
    public QueryTaskListener mListener;

    public interface QueryTaskListener
    {
        public void onQueryProductionStart();
        public void onQueryProductionFinish(String res);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mListener != null){
            mListener.onQueryProductionStart();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        String response = null;
        String sUrl = ConstantValues.URL_BASE + "production/";
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
            mListener.onQueryProductionFinish(result);
        }
    }
}
