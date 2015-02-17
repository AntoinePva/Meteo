package izi.meteo.Data;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by matthieu on 06/02/2015.
 */
public class DataController {

    private DataModel currentLocation;
    public static ArrayList<DataModel> listLocation;
    private String syncLocation;


    public static ArrayList<DataModel> getListLocation() {
        return listLocation;
    }

    public DataModel findLocation(String name) {


        try {
            this.syncLocation= new DataAsync().execute(name,Option.FIND.toString()).get();
            return fillDataModel(this.syncLocation);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }



    private DataModel fillDataModel(String data){
        try {
            JSONObject jObj = new JSONObject(data);
            DataModel newModel= new DataModel();
            newModel.setName(getString("name",jObj));
            return newModel;

        } catch (JSONException e) {e.printStackTrace();}

        return null;
    }

    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }

}

