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
        String currenciesList = "https://free.currconv.com/api/v7/currencies?apiKey=da209d38ceed1164c615";

        HttpSender send = new HttpSender();
        String response = send.sendHTTP(currenciesList);
        JSONObject entireJSON = new JSONObject(response.trim());
        JSONObject resultsObject = entireJSON.getJSONObject("results".trim());
        Iterator<String> keys = resultsObject.keys();
        List<String> currencyList = new ArrayList();

        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject currSep = resultsObject.getJSONObject(key);
            String curr = currSep.getString("id") + " - " + currSep.getString("currencyName");
            currencyList.add(curr);
        }

        List<String> sortedList = currencyList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return sortedList;
    }

    @WebMethod(operationName = "getMyConversionRate")
    public double GetConversionRate(String curr, String cur2) {
        String convList = "https://free.currconv.com/api/v7/convert?apiKey=da209d38ceed1164c615&q=GBP_" + cur2 + "&compact=y";
        HttpSender send = new HttpSender();
        String key = "GBP_" + cur2;
        String convResponse = send.sendHTTP(convList);
        JSONObject entireJSON = new JSONObject(convResponse.trim());
        JSONObject valueRemoved = entireJSON.getJSONObject(key);
        double conv = valueRemoved.getDouble("val");
        return conv;
    }
}
