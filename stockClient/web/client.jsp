<%-- 
    Document   : client
    Created on : 01-Dec-2020, 12:05:01
    Author     : Kyle
--%>

<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.netbeans.xml.schema.shares.StockType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kyle's Stock Program</title>


        <style>
            body {
                font: 400 15px Lato, sans-serif;
                line-height: 1.8;
                color: #818181;
            }

            h2 {
                font-size: 24px;
                color: #303030;
                font-weight: 600;
                margin-bottom: 30px;
            }
            h4 {
                font-size: 19px;
                line-height: 1.375em;
                color: #303030;
                font-weight: 400;
                margin-bottom: 30px;
            }  
            .jumbotron {
                background-color: #C5B358;
                color: #fff;
                padding: 100px 25px;
                font-family: Montserrat, sans-serif;
            }

            footer {
                background-color: #555;
                color: white;
            }

            newsreel {
                overflow-y: scroll;              
                height: 100px;
                width: 100%;
                background-color: #dfdfdf;
            }

        </style>
    </head>

    <body>



        <nav class="row bg-white fixed-top"style="padding:10px">

            <div class="col-sm-1"></div>
            <div class="col-sm-5" ><form method="POST" action="?search" >
                    <input type="text" name="stockSymbol"/>
                    <button type ="submit" value="Search"class="btn btn-outline-secondary btn-lg">Search Stocks</button>
                </form></div>

            <div class="col-sm-5" >   
                <div style="text-align: right">
                    <form method="POST" action="?currency" >
                        <%

                            docwebservices.CurrencyConversionWSService services = new docwebservices.CurrencyConversionWSService();
                            docwebservices.CurrencyConversionWS portCS = services.getCurrencyConversionWSPort();
                            java.util.List<java.lang.String> resultCS = portCS.getCurrencyCodes(); //CS is Currency Service                            

                            org.myws.StockWebService_Service serviceWS = new org.myws.StockWebService_Service();
                            org.myws.StockWebService port = serviceWS.getStockWebServicePort();
                            //port.updatePrices();

                            out.println("<select name='currencyOption'>");
                            for (String c : resultCS) {
                                if (c.equals("GBP - British pound")) {
                                    out.println("<option value='" + c + "' selected>" + c + "</option>");
                                } else {
                                    out.println("<option value='" + c + "'>" + c + "</option>");
                                }
                            }
                            out.println("</select>");
                        %>
                        <button type ="submit" value="Convert"class="btn btn-outline-secondary btn-lg">Currency</button>
                    </form></div>                                      
            </div>
            <div class="col-sm-1"></div>
        </nav>


        <div class="jumbotron text-center">
            <h1>Kyle's Stock Program</h1>
        </div>



        <%-- start web service invocation --%><hr/>
        <div class ="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8 text-center">
                <form method="POST" action="?sortBy"> Sort Stocks by:                
                    <button name= "order" type ="submit" value="priceOrder"class="btn btn-outline-secondary btn-lg">Price</button>   
                    <button name= "order" type ="submit" value="shareOrder"class="btn btn-outline-secondary btn-lg">No of Shares</button>  
                    <button name= "order" type ="submit" value="dateOrder"class="btn btn-outline-secondary btn-lg">Last Update</button> 
                    <button name= "order" type ="submit" value="return"class="btn btn-outline-secondary btn-lg">Any</button> 
                </form>  
            </div>
            <div class="col-sm-2"></div>
        </div>

        <div class ="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10 text-center">
                <%
                    java.util.List<org.netbeans.xml.schema.shares.StockType> result;

                    String outcome = null; //string for the buying and selling
                    if (request.getParameter("search") != null) { //search function
                        String stockName = request.getParameter("stockSymbol");

                        result = port.searchStock(stockName); // port.searchbystock from the webserver passing stockname as parameter                
                    } else if (request.getParameter("sortBy") != null) {
                        String sortBy = request.getParameter("order");

                        if (sortBy.equals("priceOrder")) {
                            result = port.priceOrder();
                        } else if (sortBy.equals("shareOrder")) {
                            result = port.shareOrder();
                        } else if (sortBy.equals("dateOrder")) {
                            result = port.dateOrder();
                        } else {
                            result = port.allStocks();
                        }
                    } else if (request.getParameter("buy") != null) {
                        String stockName = request.getParameter("buySymbol");
                        int stockAmount = Integer.parseInt(request.getParameter("buyButton"));
                        if (port.shareBuy(stockName, stockAmount) == true) {
                            outcome = "Successful Purchase";
                            out.println(outcome);
                            result = port.allStocks();
                        } else {
                            outcome = "Purchase Unsuccessful";
                            out.println(outcome);
                            result = port.allStocks();
                        };
                    } else if (request.getParameter("sell") != null) {
                        String stockName = request.getParameter("sellSymbol");
                        int stockAmount = Integer.parseInt(request.getParameter("sellButton"));
                        if (port.shareSell(stockName, stockAmount) == true) {
                            outcome = "Successful Sale";
                            out.println(outcome);
                            result = port.allStocks();
                        } else {
                            outcome = "Sale Unsuccessful";
                            out.println(outcome);
                            result = port.allStocks();
                        };

                    } else {
                        //all stocks
                        result = port.allStocks();
                    }

                    //converter bit
                    double convResult = 1;
                    DecimalFormat df = new DecimalFormat("0.00"); //decimal format for reducing the table down to 2 decimal places as double is to like 6
                    String currency = "GBP"; //defaults to GBP

                    if (request.getParameter("currency") != null && request.getParameter("currencyOption") != null && !request.getParameter("currencyOption").equals("GBP - British pound")) {
                        java.lang.String arg0 = "GBP";
                        String[] s = request.getParameter("currencyOption").split(" ");
                        currency = s[0];
                        convResult = portCS.getConversionRate(arg0, currency); //gives the conversion result to times by in the table
                    }

                    out.println(
                            "<hr/><table class='table'><td>Stock Name</td><td>Stock Symbol</td><td>Stock Amount</td><td>Curr</td><td>Stock Price</td><td>Last Updated</td><td>Buy</td><td>Sell</td>");
                    for (StockType Stock : result) {
                        out.println("<tr>");
                        out.println("<td>" + Stock.getName() + "</td>");
                        out.println("<td>" + Stock.getCode() + "</td>");
                        out.println("<td>" + Stock.getShareNo() + "</td>");
                        out.println("<td>" + currency + "</td>");
                        out.println("<td>" + df.format(Stock.getStockPrice().getSharePrice() * convResult) + "</td>");
                        out.println("<td>" + Stock.getStockPrice().getDate() + "</td>");
                        out.println("<td><form method='POST' action='?buy'><input type='hidden' name='buySymbol' value='" + Stock.getName() + "' /> <input type='text' style = 'width: 50px' name='buyButton'/><button type ='submit' value='Buy'class='btn btn-outline-secondary btn-lg'>Buy</button></form></td>");
                        out.println("<td><form method='POST' action='?sell'><input type='hidden' name='sellSymbol' value='" + Stock.getName() + "' /> <input type='text' style = 'width: 50px' name='sellButton'/><button type ='submit' value='Sell'class='btn btn-outline-secondary btn-lg'>Sell</button></form></td>");
                        out.println("</tr>");
                    }
                    out.println(
                            "</table>");

                %>

            </div>
            <div class="col-sm-1"></div>
        </div>
                <div class ="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8 text-center">
               <form method="POST" action="?update" >                   
                    <button type ="submit" value="Update"class="btn btn-outline-secondary btn-lg">Update Stocks</button>
                </form></div>> 
               <%   
                if (request.getParameter("update") != null) {
                        port.updatePrices();
                }
                   %>
            <div class="col-sm-2"></div>
        </div>



        <div class ="container rounded"style="background-color: #C5B358" >

            <div class="text-center"style="color:white">
                <h2 class="pt-4"style="color: white">News</h2>  
            </div>                                  
        </div>
        <div class ="pre-scrollable container rounded"style="background-color: #dfdfdf; height:400px">            

            <div class=" text-center pt-sm-5 ">                
                <%                            DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
                    Date date = new Date();
                    String todate = dateFormat.format(date);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, -7);
                    Date todate1 = cal.getTime();
                    String date1 = dateFormat.format(todate1);
                    String api = "https://content.guardianapis.com/business/stock-markets?from-date=" + date1 + "&order-by=newest&api-key=09644f75-a4a9-45cf-a9da-bc1f43dc184c";

                    URL url = new URL(api);

                    HttpURLConnection connURL = (HttpURLConnection) url.openConnection();
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
                    for (int i = 0; i < resultsArray.length(); i++) {
                        out.println("<div style='width:100%; padding:5px;'><h4>" + resultsArray.getJSONObject(i).getString("webTitle") + "</h4><p>" + resultsArray.getJSONObject(i).getString("webPublicationDate") + "</p><a href='" + resultsArray.getJSONObject(i).getString("webUrl") + "' target='_blank'>Read this news story</a></p></div>");
                    }
                %>
            </div>

        </div>

        <footer class="container-fluid text-center">
            <p>Kyle Angell-Walker</p>
            <p>N0832083 SCCC</p>
        </footer>

    </body>
</html>
