/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http.thingy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class HttpThingy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        String url = "https://api.polygon.io/v1/open-close/AAPL/2020-10-14?apiKey=1jnki8F0D4jbjuzjIY8GMCLWhf1s0wC7";
        StringBuffer response = new StringBuffer();
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        Integer responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();
        }
        
        JSONObject json = new JSONObject(response.toString());        
        double close = json.getDouble("close");
        System.out.println(close);
        
        
    }

}
