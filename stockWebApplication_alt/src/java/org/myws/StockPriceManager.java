/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myws;

/**
 *
 * @author Kyle
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Kyle
 */
public class StockPriceManager {
   
    public double updateStockPrice(String sym){
        double result = 0.0;
        String url = "http://api.marketstack.com/v1/eod/latest?access_key=a7f06d13707cdd114b37a4babfea18f3&symbols="+sym;
        HttpSender sender = new HttpSender();
        String response = sender.sendHTTP(url);
        if(response != null && !response.equals("")){
            try{
        JSONObject entireJSON = new JSONObject(response);
           
        JSONArray resultsArray = entireJSON.getJSONArray("data");
        result = resultsArray.getJSONObject(0).getDouble("close");
            }catch(JSONException e){
                System.out.println("theres been a vital error in stock price manager :"+e);
            }
        }
        return result;
    }
    
}