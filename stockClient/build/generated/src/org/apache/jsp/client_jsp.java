package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import stock.client.StockPriceManager;
import stock.client.http.HttpSender;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;
import java.text.DecimalFormat;
import org.netbeans.xml.schema.shares.StockType;

public final class client_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Kyle's Stock Program</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                font: 400 15px Lato, sans-serif;\r\n");
      out.write("                line-height: 1.8;\r\n");
      out.write("                color: #818181;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            h2 {\r\n");
      out.write("                font-size: 24px;\r\n");
      out.write("                color: #303030;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("                margin-bottom: 30px;\r\n");
      out.write("            }\r\n");
      out.write("            h4 {\r\n");
      out.write("                font-size: 19px;\r\n");
      out.write("                line-height: 1.375em;\r\n");
      out.write("                color: #303030;\r\n");
      out.write("                font-weight: 400;\r\n");
      out.write("                margin-bottom: 30px;\r\n");
      out.write("            }  \r\n");
      out.write("            .jumbotron {\r\n");
      out.write("                background-color: #C5B358;\r\n");
      out.write("                color: #fff;\r\n");
      out.write("                padding: 100px 25px;\r\n");
      out.write("                font-family: Montserrat, sans-serif;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            footer {\r\n");
      out.write("                background-color: #555;\r\n");
      out.write("                color: white;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            newsreel {\r\n");
      out.write("                overflow-y: scroll;              \r\n");
      out.write("                height: 100px;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                background-color: #dfdfdf;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"row bg-white fixed-top\"style=\"padding:10px\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-1\"></div>\r\n");
      out.write("            <div class=\"col-sm-5\" ><form method=\"POST\" action=\"?search\" >\r\n");
      out.write("                    <input type=\"text\" name=\"stockSymbol\"/>\r\n");
      out.write("                    <button type =\"submit\" value=\"Search\"class=\"btn btn-outline-secondary btn-lg\">Search Stocks</button>\r\n");
      out.write("                </form></div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-5\" >   \r\n");
      out.write("                <div style=\"text-align: right\">\r\n");
      out.write("                    <form method=\"POST\" action=\"?currency\" >\r\n");
      out.write("                        ");


                            docwebservices.CurrencyConversionWSService services = new docwebservices.CurrencyConversionWSService();
                            docwebservices.CurrencyConversionWS portw = services.getCurrencyConversionWSPort();
                            
                            java.util.List<java.lang.String> resultw = portw.getCurrencyCodes();

                            org.myws.StockWebService_Service service = new org.myws.StockWebService_Service();
                            org.myws.StockWebService port = service.getStockWebServicePort();
                            //java.util.List<java.lang.String> resultw = port.getCurrency();
                            out.println("<select name='currencyOption'>");
                            for (String c : resultw) {
                                if (c.equals("GBP - British pound")) {
                                    out.println("<option value='" + c + "' selected>" + c + "</option>");
                                } else {
                                    out.println("<option value='" + c + "'>" + c + "</option>");
                                }
                            }
                            out.println("</select>");
                        
      out.write("\r\n");
      out.write("                        <button type =\"submit\" value=\"Convert\"class=\"btn btn-outline-secondary btn-lg\">Currency</button>\r\n");
      out.write("                    </form></div>                                      \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-1\"></div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"jumbotron text-center\">\r\n");
      out.write("            <h1>Kyle's Stock Program</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<hr/>\r\n");
      out.write("        <div class =\"row\">\r\n");
      out.write("            <div class=\"col-sm-2\"></div>\r\n");
      out.write("            <div class=\"col-sm-8 text-center\">\r\n");
      out.write("                <form method=\"POST\" action=\"?sortBy\"> Sort Stocks by:                \r\n");
      out.write("                    <button name= \"order\" type =\"submit\" value=\"priceOrder\"class=\"btn btn-outline-secondary btn-lg\">Price</button>   \r\n");
      out.write("                    <button name= \"order\" type =\"submit\" value=\"shareOrder\"class=\"btn btn-outline-secondary btn-lg\">No of Shares</button>  \r\n");
      out.write("                    <button name= \"order\" type =\"submit\" value=\"dateOrder\"class=\"btn btn-outline-secondary btn-lg\">Last Update</button> \r\n");
      out.write("                    <button name= \"order\" type =\"submit\" value=\"return\"class=\"btn btn-outline-secondary btn-lg\">Any</button> \r\n");
      out.write("                </form>  \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class =\"row\">\r\n");
      out.write("            <div class=\"col-sm-1\"></div>\r\n");
      out.write("            <div class=\"col-sm-10 text-center\">\r\n");
      out.write("                ");
  //org.myws.StockWebService_Service service = new org.myws.StockWebService_Service();
                    //org.myws.StockWebService port = service.getStockWebServicePort();
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
                    DecimalFormat df = new DecimalFormat("0.00");
                    String currency = "GBP";
                    
                    if (request.getParameter("currency") != null && request.getParameter("currencyOption") != null && !request.getParameter("currencyOption").equals("GBP - British pound")) {
                        java.lang.String arg0 = "GBP";
                        String[] s = request.getParameter("currencyOption").split(" ");
                        currency = s[0];                        
                        convResult = portw.getConversionRate(arg0, currency);
                    }
                        
                       
                        out.println(
                                "<hr/><table class='table'><td>Stock Name</td><td>Stock Symbol</td><td>Stock Amount</td><td>Curr</td><td>Stock Price</td><td>Last Updated</td><td>Buy</td><td>Sell</td>");
                        for (StockType Stock : result) {
                            StockPriceManager price = new StockPriceManager();
                            Stock.getStockPrice().setSharePrice(price.updateStockPrice(Stock.getCode()));
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
                            Thread.sleep(10);
                        }
                            
                        out.println(
                                "</table>");

                    // news rest api Your API key is: 22afeb52ffe4498f9ed0a6657a18485a
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class =\"container rounded\"style=\"background-color: #C5B358\" >\r\n");
      out.write("\r\n");
      out.write("            <div class=\"text-center\"style=\"color:white\">\r\n");
      out.write("                <h2 class=\"pt-4\"style=\"color: white\">News</h2>  \r\n");
      out.write("            </div>                                  \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class =\"pre-scrollable container rounded\"style=\"background-color: #dfdfdf; height:400px\">            \r\n");
      out.write("\r\n");
      out.write("            <div class=\" text-center pt-sm-5 \">                \r\n");
      out.write("                ");
                            DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
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
                        out.println("<div style='width:100%; padding:5px;'><h4>" + resultsArray.getJSONObject(i).getString("webTitle") + "</h4><p>"+ resultsArray.getJSONObject(i).getString("webPublicationDate") +"</p><a href='" + resultsArray.getJSONObject(i).getString("webUrl") + "' target='_blank'>Read this news story</a></p></div>");
                    }
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      \r\n");
      out.write("        <footer class=\"container-fluid text-center\">\r\n");
      out.write("            <p>Kyle Angell-Walker</p>\r\n");
      out.write("            <p>N0832083 SCCC</p>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
