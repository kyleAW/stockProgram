package CurrencyConverter;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */

public class HttpSender {
    
    public String sendHTTP(String url) {
        StringBuffer response = new StringBuffer();
        try{
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

            
        }}
        catch(Exception e){
            System.out.println("Theres been a problem with the Currency :"+e);
        }        
        
        return response.toString();
    }
}
