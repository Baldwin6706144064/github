package com.example.android.quakereport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Praktikan on 23/03/2017.
 */

public final class JsonUtils {
    private static String jsonData = "{  \n" +
            "   \"type\":\"FeatureCollection\",\n" +
            "   \"metadata\":{  \n" +
            "      \"generated\":1490253666000,\n" +
            "      \"url\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02&minmagnitude=5\",\n" +
            "      \"title\":\"USGS Earthquakes\",\n" +
            "      \"status\":200,\n" +
            "      \"api\":\"1.5.7\",\n" +
            "      \"count\":2\n" +
            "   },\n" +
            "   \"features\":[  \n" +
            "      {  \n" +
            "         \"type\":\"Feature\",\n" +
            "         \"properties\":{  \n" +
            "            \"mag\":6.5,\n" +
            "            \"place\":\"32km W of Sola, Vanuatu\",\n" +
            "            \"time\":1388592209000,\n" +
            "            \"updated\":1394151955000,\n" +
            "            \"tz\":660,\n" +
            "            \"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/usc000lvb5\",\n" +
            "            \"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=usc000lvb5&format=geojson\",\n" +
            "            \"felt\":null,\n" +
            "            \"cdi\":null,\n" +
            "            \"mmi\":4.84,\n" +
            "            \"alert\":\"green\",\n" +
            "            \"status\":\"reviewed\",\n" +
            "            \"tsunami\":1,\n" +
            "            \"sig\":650,\n" +
            "            \"net\":\"us\",\n" +
            "            \"code\":\"c000lvb5\",\n" +
            "            \"ids\":\",at00myqcls,pt14001000,usc000lvb5,\",\n" +
            "            \"sources\":\",at,pt,us,\",\n" +
            "            \"types\":\",cap,geoserve,impact-link,losspager,moment-tensor,moment-tensor,moment-tensor,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
            "            \"nst\":null,\n" +
            "            \"dmin\":3.997,\n" +
            "            \"rms\":0.76,\n" +
            "            \"gap\":14,\n" +
            "            \"magType\":\"mww\",\n" +
            "            \"type\":\"earthquake\",\n" +
            "            \"title\":\"M 6.5 - 32km W of Sola, Vanuatu\"\n" +
            "         },\n" +
            "         \"geometry\":{  \n" +
            "            \"type\":\"Point\",\n" +
            "            \"coordinates\":[  \n" +
            "               167.249,\n" +
            "               -13.8633,\n" +
            "               187\n" +
            "            ]\n" +
            "         },\n" +
            "         \"id\":\"usc000lvb5\"\n" +
            "      },\n" +
            "      {  \n" +
            "         \"type\":\"Feature\",\n" +
            "         \"properties\":{  \n" +
            "            \"mag\":5.1,\n" +
            "            \"place\":\"76km NNW of Davila, Philippines\",\n" +
            "            \"time\":1388534476610,\n" +
            "            \"updated\":1394151953000,\n" +
            "            \"tz\":480,\n" +
            "            \"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/usc000lv5e\",\n" +
            "            \"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=usc000lv5e&format=geojson\",\n" +
            "            \"felt\":null,\n" +
            "            \"cdi\":null,\n" +
            "            \"mmi\":null,\n" +
            "            \"alert\":null,\n" +
            "            \"status\":\"reviewed\",\n" +
            "            \"tsunami\":0,\n" +
            "            \"sig\":400,\n" +
            "            \"net\":\"us\",\n" +
            "            \"code\":\"c000lv5e\",\n" +
            "            \"ids\":\",usc000lv5e,\",\n" +
            "            \"sources\":\",us,\",\n" +
            "            \"types\":\",cap,general-link,geoserve,nearby-cities,origin,phase-data,tectonic-summary,\",\n" +
            "            \"nst\":null,\n" +
            "            \"dmin\":3.794,\n" +
            "            \"rms\":0.85,\n" +
            "            \"gap\":29,\n" +
            "            \"magType\":\"mb\",\n" +
            "            \"type\":\"earthquake\",\n" +
            "            \"title\":\"M 5.1 - 76km NNW of Davila, Philippines\"\n" +
            "         },\n" +
            "         \"geometry\":{  \n" +
            "            \"type\":\"Point\",\n" +
            "            \"coordinates\":[  \n" +
            "               120.2389,\n" +
            "               19.0868,\n" +
            "               10.07\n" +
            "            ]\n" +
            "         },\n" +
            "         \"id\":\"usc000lv5e\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"bbox\":[  \n" +
            "      120.2389,\n" +
            "      -13.8633,\n" +
            "      10.07,\n" +
            "      167.249,\n" +
            "      19.0868,\n" +
            "      187\n" +
            "   ]\n" +
            "}";

    public static ArrayList<Earthquake> getEarthQuakeData(){
        ArrayList<Earthquake> arrearthquake = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonData);
            JSONArray features = root.getJSONArray("features");
            for(int i = 0; i < features.length(); i++){
                JSONObject properties = features.getJSONObject(i).getJSONObject("properties");
                arrearthquake.add(new Earthquake(
                        properties.getDouble("mag"),
                        properties.getString("place"),
                        properties.getLong("time")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrearthquake;
    }
}
