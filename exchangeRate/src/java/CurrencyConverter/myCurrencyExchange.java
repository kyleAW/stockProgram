/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyConverter;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Kyle
 */
@WebService(serviceName = "myCurrencyExchange")
public class myCurrencyExchange {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getMyCurrencyCodes")
    public List<String> GetCurrencyCodes() {
        String currenciesList = "https://free.currconv.com/api/v7/currencies?apiKey=da209d38ceed1164c615"; //the latest currency list url string

        HttpSender send = new HttpSender(); //creates a new sender
        String response = send.sendHTTP(currenciesList); //passes the string to the sender
        JSONObject entireJSON = new JSONObject(response.trim());
        JSONObject resultsObject = entireJSON.getJSONObject("results".trim());//gets the results in a json object
        Iterator<String> keys = resultsObject.keys(); //creates an iterator for the keys in the json object
        List<String> currencyList = new ArrayList(); //creates a new blank list for the currencies

        while (keys.hasNext()) { //while theres another key in the list
            String key = keys.next();
            JSONObject currSep = resultsObject.getJSONObject(key); //get the object at that key
            String curr = currSep.getString("id") + " - " + currSep.getString("currencyName"); //create a string with the id and currency name for that key
            currencyList.add(curr); //add it to the list above
        }

        List<String> sortedList = currencyList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()); //sort the list by alphabetical order
        return sortedList; //return the sorted list for the combo box to use
    }

    @WebMethod(operationName = "getMyConversionRate")
    public double GetConversionRate(String curr, String cur2) {
        String convList = "https://free.currconv.com/api/v7/convert?apiKey=da209d38ceed1164c615&q=GBP_" + cur2 + "&compact=y"; //take the currency passed throuugh and add to the string
        HttpSender send = new HttpSender(); //create a new sender
        String key = "GBP_" + cur2;
        String convResponse = send.sendHTTP(convList); //pass the string to the http sender
        JSONObject entireJSON = new JSONObject(convResponse.trim()); //get the response and turn it into ajson object
        JSONObject valueRemoved = entireJSON.getJSONObject(key); //get the object at the key
        double conv = valueRemoved.getDouble("val"); //from the object get the val to get the exchange rate
        return conv; //return the exchange rate
    }
}
