/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
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
 * REST Web Service
 *
 * @author Kyle
 */
@Path("generic")
public class GenericResource {

    @Context
    String company;
    String htmlContent;
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of restAPI.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(String company) { //string company is from the put request
       
        htmlContent = "";        //define the html content
        String api = "https://content.guardianapis.com/search?q=%22" + company + "%22&api-key=09644f75-a4a9-45cf-a9da-bc1f43dc184c";  //the string for the news feed

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

                JSONObject wholeJSON = new JSONObject(JSONresultStr.toString());//creates a json object from the result string gained from the get response
                JSONObject responseJSON = wholeJSON.getJSONObject("response"); // make an object of the entire json file
                JSONArray resultsArray = responseJSON.getJSONArray("results");  //make an array of the object from the results locator

                for (int i = 0; i < resultsArray.length(); i++) {
                    //build the html code for the page getting the title and url from each result from the response
                    htmlContent += "<div><h1>" + resultsArray.getJSONObject(i).getString("webTitle") + "</h1><a href=\'" + resultsArray.getJSONObject(i).getString("webUrl") + "\'>" + resultsArray.getJSONObject(i).getString("webUrl") + "</a></div><hr/>";
                }
            } catch (IOException ex) { //in a try catch incase of IO exception
                Logger.getLogger("IO Exception" + ex);
            }
        } catch (MalformedURLException ex) { //in a try catch incase the url doesnt work for what ever reason
            Logger.getLogger("URL Exception" + ex);
        }
        return htmlContent;
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT 
    @Consumes(MediaType.TEXT_HTML)
    public String putHtml(String company) {
        String content = getHtml(company);  //put requests the getHTML to get the latest news and convert it into a html page for the client
        return content;        //returns the latest news html page to the restAPI in client
    }
}
