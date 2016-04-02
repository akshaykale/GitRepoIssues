package com.akshaykale.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpManager {
	
	public static String getData(String url_path) {
        Log.d("url", "hm 1");
        InputStream is = null;
        String result="";
        StringBuilder response_str = null;
        try {
            URL url = new URL(url_path);
            Log.d("url", "hm 2");
            URLConnection con = url.openConnection();
            Log.d("url", "hm 3");
            if(con instanceof HttpURLConnection){
                Log.d("url", "hm 4");
                HttpURLConnection httpURLConnection = (HttpURLConnection)con;
                httpURLConnection.setRequestMethod("GET");
                int response = -1;

                httpURLConnection.connect();
                response = httpURLConnection.getResponseCode();
                Log.d("url", "hm 5 code" +response);
                if(response == HttpURLConnection.HTTP_OK){

                    is = httpURLConnection.getInputStream();

                    BufferedReader r = new BufferedReader(new InputStreamReader(is));
                    response_str = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response_str.append(line);
                    }
                    result=response_str.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
