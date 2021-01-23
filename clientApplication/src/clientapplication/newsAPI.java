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

import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class newsAPI {

    //the news api - gets the latest news for what ever stock is selected and converts it to a html page for the client application to display in the newsfeed
    String htmlContent;

    public String newsFeed(String company) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        String date1 = dateFormat.format(todate1);
        htmlContent = "";        //define the html content
        String api = "https://content.guardianapis.com/search?from-date=" + date1 + "&q=" + company + "&api-key=09644f75-a4a9-45cf-a9da-bc1f43dc184c";  //the string for the news feed

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

                JSONObject entireJSON = new JSONObject(JSONresultStr.toString());//creates a json object from the result string gained from the get response
                JSONObject responseJSON = entireJSON.getJSONObject("response"); // make an object of the entire json file
                JSONArray resultsArray = responseJSON.getJSONArray("results");  //make an array of the object from the results locator

                for (int i = 0; i < resultsArray.length(); i++) {
                    //build the html code for the page getting the title and url from each result from the response
                    htmlContent += "<div><h1>" + resultsArray.getJSONObject(i).getString("webTitle") + "</h1><a href=\'" + resultsArray.getJSONObject(i).getString("webUrl") + "\'>" + resultsArray.getJSONObject(i).getString("webUrl") + "</a></div><hr/>";
                }
            } catch (IOException ex) { //in a try catch incase of IO exception
                Logger.getLogger(newsAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) { //in a try catch incase the url doesnt work for what ever reason
            Logger.getLogger(newsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return htmlContent;
    }

}
