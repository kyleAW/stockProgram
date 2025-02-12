
package currencyconverter;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "myCurrencyExchange", targetNamespace = "http://CurrencyConverter/", wsdlLocation = "http://localhost:8080/exchangeRate/myCurrencyExchange?wsdl")
public class MyCurrencyExchange_Service
    extends Service
{

    private final static URL MYCURRENCYEXCHANGE_WSDL_LOCATION;
    private final static WebServiceException MYCURRENCYEXCHANGE_EXCEPTION;
    private final static QName MYCURRENCYEXCHANGE_QNAME = new QName("http://CurrencyConverter/", "myCurrencyExchange");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/exchangeRate/myCurrencyExchange?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYCURRENCYEXCHANGE_WSDL_LOCATION = url;
        MYCURRENCYEXCHANGE_EXCEPTION = e;
    }

    public MyCurrencyExchange_Service() {
        super(__getWsdlLocation(), MYCURRENCYEXCHANGE_QNAME);
    }

    public MyCurrencyExchange_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns MyCurrencyExchange
     */
    @WebEndpoint(name = "myCurrencyExchangePort")
    public MyCurrencyExchange getMyCurrencyExchangePort() {
        return super.getPort(new QName("http://CurrencyConverter/", "myCurrencyExchangePort"), MyCurrencyExchange.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyCurrencyExchange
     */
    @WebEndpoint(name = "myCurrencyExchangePort")
    public MyCurrencyExchange getMyCurrencyExchangePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://CurrencyConverter/", "myCurrencyExchangePort"), MyCurrencyExchange.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYCURRENCYEXCHANGE_EXCEPTION!= null) {
            throw MYCURRENCYEXCHANGE_EXCEPTION;
        }
        return MYCURRENCYEXCHANGE_WSDL_LOCATION;
    }

}
