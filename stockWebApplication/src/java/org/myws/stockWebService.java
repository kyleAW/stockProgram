/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myws;

import currencyconverter.MyCurrencyExchange_Service;
import docwebservices.CurrencyConversionWSService;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.datatype.XMLGregorianCalendar;
import stocks.StockPortfolio;
import stocks.StockType;
import java.util.Calendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.WebServiceRef;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
@WebService(serviceName = "stockWebService")
public class stockWebService {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/exchangeRate/myCurrencyExchange.wsdl")
    private MyCurrencyExchange_Service service_1;  //for the new realtime currency and exchange rate api

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CurrencyConvertor/CurrencyConversionWSService.wsdl")
    private CurrencyConversionWSService service;   //for the old webservice currency from taha

    private final String xmlLocation = "D:\\Kyle\\Documents\\Work\\Year 3\\Cloud Comp\\stockProgram\\stockWebApplication\\src\\java\\org\\myws\\currentStocks.xml";  //xml file hardcoded to ensure the correct copy as glassfish was creating a duplicate that it wanted to use
    String name;

    /**
     * This is a sample web service operation
     *
     * @return
     */
    @WebMethod(operationName = "allStocks")
    public List<StockType> allStocks() {
        StockPortfolio stocks = new StockPortfolio();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> currentStocks = stocks.getStockCollection();
        return currentStocks; //unmarshalls into a list and returns the unorganised list

    }

    @WebMethod(operationName = "dateOrder")
    public List<StockType> dateOrder() {
        StockPortfolio stocks = new StockPortfolio();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        List<StockType> listStocks = stocks.getStockCollection();
        Comparator<StockType> dateCompare = (StockType stock1, StockType stock2) -> {
            XMLGregorianCalendar date1 = stock1.getStockPrice().getDate();      //make variable of date            
            XMLGregorianCalendar date2 = stock2.getStockPrice().getDate();       //make variable of date          
            Date dateF = date1.toGregorianCalendar().getTime();          //convert date      
            Date dateG = date2.toGregorianCalendar().getTime(); //convert date  
            if (dateF.after(dateG)) { //compare dates and reorder
                return -1;
            } else if (dateF.before(dateG)) {
                return 1;
            } else {
                return 0;
            }
        };
        listStocks.sort(dateCompare);
        return listStocks; //unmarshalls. sorts the list by the comparator to get it in date order from last update and returns the sorted list
    }

    @WebMethod(operationName = "priceOrder")
    public List<StockType> priceOrder() {
        StockPortfolio stocks = new StockPortfolio();
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> listStocks = stocks.getStockCollection();
        Comparator<StockType> dateCompare = (StockType stock1, StockType stock2) -> {
            Double firstStock = stock1.getStockPrice().getSharePrice(); //create variable from double from xml
            Double secStock = stock2.getStockPrice().getSharePrice();//create variable from double from xml
            int compare = Double.compare(firstStock, secStock);  //compare doubles from xml

            if (compare > 0) {
                return -1;
            } else if (compare < 0) {
                return 1;
            } else {
                return 0;
            }
        };
        listStocks.sort(dateCompare);
        return listStocks; //unmarshalls into a list, sorts list by the comparator for price and then returns sorted list
    }

    @WebMethod(operationName = "shareOrder")
    public List<StockType> shareOrder() {
        StockPortfolio stocks = new StockPortfolio();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> listStocks = stocks.getStockCollection();
        Comparator<StockType> dateCompare = (StockType stock1, StockType stock2) -> {
            if (stock1.getShareNo() > stock2.getShareNo()) {
                return -1;
            } else if (stock1.getShareNo() < stock2.getShareNo()) {
                return 1;
            } else {
                return 0;
            }
        };

        listStocks.sort(dateCompare);
        return listStocks; //unmarshalls into list. sorts the list by a comparator that compares the amount of shares. sorted list is then returned
    }

    @WebMethod(operationName = "shareBuy")
    public boolean shareBuy(String share, int buyStocks) {
        StockPortfolio stocks = new StockPortfolio();
        //unmarshall everything
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> listStocks = stocks.getStockCollection();
        for (StockType stock : listStocks) { //searches through the xml for the correct stock
            if (share.toLowerCase().equals(stock.getName().toLowerCase())) {

                int shareAmount = stock.getShareNo();
                System.out.println("shares currently" + shareAmount);
                System.out.println("shares trying to buy" + buyStocks);
                if (shareAmount >= buyStocks) {
                    int prices = shareAmount - buyStocks;
                    stock.setShareNo(prices);

                    try {
                        javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
                        javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        marshaller.marshal(stocks, new File(xmlLocation));
                        return true;
                    } catch (javax.xml.bind.JAXBException ex) {
                        // XXXTODO Handle exception
                        java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                    }

                } else {
                    System.out.println("not enough shares to purchase");
                    return false;
                    
                }
            }
        }

      
        return false; //temp to stop error doesnt actually make it to here ever as its either returned true or false before

    }

    @WebMethod(operationName = "shareSell")
    public boolean shareSell(String share, int buyStocks) {
        StockPortfolio stocks = new StockPortfolio();
        //unmarshall everything
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> listStocks = stocks.getStockCollection();
        for (StockType stock : listStocks) {//searches through the xml for the correct stock
            if (share.toLowerCase().equals(stock.getName().toLowerCase())) {

                int shareAmount = stock.getShareNo();
                System.out.println(shareAmount + "--number of shares");
                System.out.println(buyStocks + "--number attempting to sell");
                int prices = shareAmount + buyStocks;
                stock.setShareNo(prices);

                try { //marshalls new stock amount to the xml
                    javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
                    javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    marshaller.marshal(stocks, new File(xmlLocation));
                } catch (javax.xml.bind.JAXBException ex) {
                    // XXXTODO Handle exception
                    java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                }

                return true;

            }
        }

        return false; //to stop error never actually reaches here ever

    }

    @WebMethod(operationName = "searchStock")
    public List<StockType> searchByStock(String name) {
        StockPortfolio stocks = new StockPortfolio();
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> resultStocks = new ArrayList<>(); //creates a new blank list

        for (StockType stock : stocks.getStockCollection()) {
            if (stock.getName().toLowerCase().contains(name.toLowerCase())) {
                resultStocks.add(stock); //finds the stock from the unmarshalled list and adds it to the new array list
            }
        }

        return resultStocks; //returns the array list
    }
    
    @WebMethod(operationName = "updatePrices")
    public void updatePrices() throws DatatypeConfigurationException {
        
        StockPortfolio stocks = new StockPortfolio();
        
        
        //unmarshall everything
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            stocks = (StockPortfolio) unmarshaller.unmarshal(new java.io.File(xmlLocation)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        List<StockType> listStocks = stocks.getStockCollection();
        StringBuilder symList = new StringBuilder();
        String sym = "";
        
        for (StockType stock : listStocks) {
            symList.append(stock.getCode() + ","); //
            sym = symList.toString();
            sym = sym.substring(0, sym.length() - 1);
        }
        double volume = 0.0;
        double result = 0.0;
        String url = "http://api.marketstack.com/v1/eod/latest?access_key=eb178bef368b5bbca7611722b6ce5d60&symbols=" + sym;   //api address
        HttpSender sender = new HttpSender();
        String response = sender.sendHTTP(url);
        if (response != null && !response.equals("")) {
            try {
                JSONObject entireJSON = new JSONObject(response);
                JSONArray resultsArray = entireJSON.getJSONArray("data");         // json comes through as an array of objects get the object labeled as data         
         
                for (int i = 0; i < resultsArray.length(); i++) { // theres a problem with it going through the stocks
                    String stockSYM = resultsArray.getJSONObject(i).getString("symbol"); //from the data object pull symbol
                    double stockPrice = resultsArray.getJSONObject(i).getDouble("close");//from the data object pull the close balance
                    volume = resultsArray.getJSONObject(i).getDouble("volume");          //from the data object pull the volume
                    String[] dateFetch = resultsArray.getJSONObject(i).getString("date").split("T"); //from the data object pull the date, splitting at the T as we only want the date not the time                  
                    XMLGregorianCalendar XMLGregdate = DatatypeFactory.newInstance()    //xml uses gregorian calender so creates a new isntance of it to turn the string date into the correct format
                .newXMLGregorianCalendar(dateFetch[0]);
                   
                    int vol = (int)volume; //turns the double of the volume into an int for the xml                    
                    for (StockType stockName : listStocks) {
                        
                        if (stockSYM.toLowerCase().equals(stockName.getCode().toLowerCase())) {
                            
                            try {                                
                                stockName.getStockPrice().setSharePrice(stockPrice); //set the share price
                                stockName.getStockPrice().setDate(XMLGregdate); //set the date
                                stockName.setShareNo(vol);                      //set the amount of shares avaliable
                                javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(stocks.getClass().getPackage().getName());
                                javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                                marshaller.marshal(stocks, new File(xmlLocation));
                            } catch (javax.xml.bind.JAXBException ex) {
                                // XXXTODO Handle exception
                                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                System.out.println("theres been a vital error in stock price manager :" + e);
            }
        }
    }

    @WebMethod(operationName = "getConversionRate")
    public double getMyConversionRate(java.lang.String arg0, java.lang.String arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        currencyconverter.MyCurrencyExchange port = service_1.getMyCurrencyExchangePort();
        return port.getMyConversionRate(arg0, arg1);
    }
    
     @WebMethod(operationName = "getCurrencyCodes")
    public java.util.List<java.lang.String> getMyCurrencyCodes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        currencyconverter.MyCurrencyExchange port = service_1.getMyCurrencyExchangePort();
        return port.getMyCurrencyCodes();
    }

    

    
 


}
