package com.example.android.myapp.utilities;

import android.content.ContentValues;
import android.content.Context;

import com.example.android.myapp.database.Dish;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jsonutils {

    private static final String OWM_CITY = "city";
    private static final String OWM_COORD = "coord";

    /* Location coordinate */
    private static final String OWM_LATITUDE = "lat";
    private static final String OWM_LONGITUDE = "lon";

    /* Weather information. Each day's forecast info is an element of the "list" array */
    private static final String OWM_LIST = "list";

    private static final String OWM_PRESSURE = "pressure";
    private static final String OWM_HUMIDITY = "humidity";
    private static final String OWM_WINDSPEED = "speed";
    private static final String OWM_WIND_DIRECTION = "deg";

    /* All temperatures are children of the "temp" object */
    private static final String OWM_TEMPERATURE = "temp";

    /* Max temperature for the day */
    private static final String OWM_MAX = "max";
    private static final String OWM_MIN = "min";

    private static final String OWM_WEATHER = "weather";
    private static final String OWM_WEATHER_ID = "id";

    private static final String OWM_MESSAGE_CODE = "cod";


    public static Map[] getWeatherContentValuesFromJson(/*Context context,*/ String forecastJsonStr)
            throws JSONException {

        JSONArray jsonWeatherArray = new JSONArray(forecastJsonStr);

        Map[] weatherContentValues = new Map[jsonWeatherArray.length()];

        for (int i = 0; i < jsonWeatherArray.length(); i++) {


            JSONObject dayForecast = jsonWeatherArray.getJSONObject(i);

               int id = dayForecast.getInt("id");
            String dish = dayForecast.getString("dishName");
            Map weatherValues = new HashMap();
            weatherValues.put("id", id);
            weatherValues.put("dishName", dish);
            weatherValues.put("dish",new Dish(dish));

            weatherContentValues[i] = weatherValues;
        }

        return weatherContentValues;
    }


    public static Map[] getWeatherContentValuesFromJsonfull(String forecastJsonStr)
            throws JSONException {

        JSONArray jsonWeatherArray = new JSONArray(forecastJsonStr);

        Map[] weatherContentValues = new Map[jsonWeatherArray.length()];

        for (int i = 0; i < jsonWeatherArray.length(); i++) {



            JSONObject dayForecast = jsonWeatherArray.getJSONObject(i);

            /*
              We ignore all the datetime values embedded in the JSON and assume that
              the values are returned in-order by day (which is not guaranteed to be correct).
            */
            //   dateTimeMillis = normalizedUtcStartDay + SunshineDateUtils.DAY_IN_MILLIS * i;
            int id = dayForecast.getInt("id");
            String dish = dayForecast.getString("dishName");
            JSONArray ingreds=dayForecast.getJSONArray("ingreds");

            Map weatherValues = new HashMap();
            weatherValues.put("id", id);
            weatherValues.put("dishName", dish);
            weatherValues.put("dish",new Dish(dish));
            weatherValues.put("ingreds",ingreds);


            weatherContentValues[i] = weatherValues;
        }

        return weatherContentValues;
    }
}
