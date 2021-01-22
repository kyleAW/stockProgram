/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class newsAPI {

    public void newsFeed(String company)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        String date1 = dateFormat.format(todate1);
        
        String api = "https://content.guardianapis.com/search?from-date=" + date1 + "&q=" + company + "&api-key=09644f75-a4a9-45cf-a9da-bc1f43dc184c";

        URL url;
        try {
            url = new URL(api);
        

        HttpURLConnection connURL;
            try {
                connURL = (HttpURLConnection) url.openConnection();
            
        connURL.setRequestMethod("GET");
        BufferedReader ins = new BufferedReader(new InputStreamReader(connURL.getInputStream()));
        String inString;
        StringBuilder JSONresultStr = new StringBuilder();

        while ((inString = ins.readLine()) != null) {
            JSONresultStr.append(inString);
        }

        ins.close();
        connURL.disconnect();    
        
        
        JSONObject entireJSON = new JSONObject(JSONresultStr.toString());
        JSONObject responseJSON = entireJSON.getJSONObject("response");
        JSONArray resultsArray = responseJSON.getJSONArray("results");
        String htmlContent = "";
        for (int i = 0; i < resultsArray.length(); i++) {
            //this bit needs to change. pulled from jsp temporarly
                        htmlContent += "<div><h1>"+resultsArray.getJSONObject(i).getString("webTitle") + "</h1><a href=\'" + resultsArray.getJSONObject(i).getString("webUrl")+"\'"+resultsArray.getJSONObject(i).getString("webUrl")+"</a>";
                    }
        } catch (IOException ex) {
                Logger.getLogger(newsAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(newsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
}
