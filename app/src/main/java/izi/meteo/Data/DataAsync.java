package izi.meteo.Data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Antoine on 04/02/2015.
 */
public class DataAsync extends AsyncTask<String, Void, String>{

    private Context mContext;
    private final String url = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String filter = "&lang=fr&units=metric";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e("preExecute","loader antoine");
    }

    @Override
    protected String doInBackground(String... params) {

        if(params[1].equals(Option.FIND.toString())){
            Log.e("doInBackground","find");
            return this.getWeatherData(params[0]);

        }else if(params[1].equals(Option.SEARCH.toString())){
            Log.e("doInBackground","search");

        }

        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        Log.e("postExecute","finish");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.e("onProgressUpdate","progress");
    }

    private String getWeatherData(String location) {
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(this.url + location + this.filter)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (  (line = br.readLine()) != null )
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }


}


