/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myws;


import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import stocks.StockPortfolio;
import stocks.StockType;

/**
 *
 * @author Kyle
 */
@WebService(serviceName = "stockWebService")
public class stockWebService {
    
    private final String xmlLocation = "D:\\Kyle\\Documents\\Work\\Year 3\\Cloud Comp\\stockProgram\\stockWebApplication\\src\\java\\org\\myws\\currentStocks.xml";
    
    
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
        return currentStocks;

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
        return listStocks;
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
        return listStocks;
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
        return listStocks;
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
        for (StockType stock : listStocks) {
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
                    //need to return false
                }
            }
        }

        System.out.println("test for this bit");
        return false; //temp to stop error

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
        for (StockType stock : listStocks) {
            if (share.toLowerCase().equals(stock.getName().toLowerCase())) {

                int shareAmount = stock.getShareNo();
                System.out.println(shareAmount + "--number of shares");
                System.out.println(buyStocks + "--number attempting to sell");
                int prices = shareAmount + buyStocks;
                stock.setShareNo(prices);

                try {
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

        return false; //temp to stop error

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

        List<StockType> resultStocks = new ArrayList<>();

        for (StockType stock : stocks.getStockCollection()) {
            if (stock.getName().toLowerCase().contains(name.toLowerCase())) {
                resultStocks.add(stock);
            }
        }

        return resultStocks;
    }

   
    
  
}
