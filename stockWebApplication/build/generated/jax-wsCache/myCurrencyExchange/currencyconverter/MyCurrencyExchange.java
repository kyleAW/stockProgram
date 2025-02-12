
package currencyconverter;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.1
 * 
 */
@WebService(name = "myCurrencyExchange", targetNamespace = "http://CurrencyConverter/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyCurrencyExchange {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMyCurrencyCodes", targetNamespace = "http://CurrencyConverter/", className = "currencyconverter.GetMyCurrencyCodes")
    @ResponseWrapper(localName = "getMyCurrencyCodesResponse", targetNamespace = "http://CurrencyConverter/", className = "currencyconverter.GetMyCurrencyCodesResponse")
    public List<String> getMyCurrencyCodes();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMyConversionRate", targetNamespace = "http://CurrencyConverter/", className = "currencyconverter.GetMyConversionRate")
    @ResponseWrapper(localName = "getMyConversionRateResponse", targetNamespace = "http://CurrencyConverter/", className = "currencyconverter.GetMyConversionRateResponse")
    public double getMyConversionRate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
