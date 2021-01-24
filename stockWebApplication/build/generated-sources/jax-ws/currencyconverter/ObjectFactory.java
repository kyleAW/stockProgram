
package currencyconverter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the currencyconverter package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMyConversionRate_QNAME = new QName("http://CurrencyConverter/", "getMyConversionRate");
    private final static QName _GetMyConversionRateResponse_QNAME = new QName("http://CurrencyConverter/", "getMyConversionRateResponse");
    private final static QName _GetMyCurrencyCodes_QNAME = new QName("http://CurrencyConverter/", "getMyCurrencyCodes");
    private final static QName _GetMyCurrencyCodesResponse_QNAME = new QName("http://CurrencyConverter/", "getMyCurrencyCodesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: currencyconverter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMyConversionRate }
     * 
     */
    public GetMyConversionRate createGetMyConversionRate() {
        return new GetMyConversionRate();
    }

    /**
     * Create an instance of {@link GetMyConversionRateResponse }
     * 
     */
    public GetMyConversionRateResponse createGetMyConversionRateResponse() {
        return new GetMyConversionRateResponse();
    }

    /**
     * Create an instance of {@link GetMyCurrencyCodes }
     * 
     */
    public GetMyCurrencyCodes createGetMyCurrencyCodes() {
        return new GetMyCurrencyCodes();
    }

    /**
     * Create an instance of {@link GetMyCurrencyCodesResponse }
     * 
     */
    public GetMyCurrencyCodesResponse createGetMyCurrencyCodesResponse() {
        return new GetMyCurrencyCodesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyConversionRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CurrencyConverter/", name = "getMyConversionRate")
    public JAXBElement<GetMyConversionRate> createGetMyConversionRate(GetMyConversionRate value) {
        return new JAXBElement<GetMyConversionRate>(_GetMyConversionRate_QNAME, GetMyConversionRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyConversionRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CurrencyConverter/", name = "getMyConversionRateResponse")
    public JAXBElement<GetMyConversionRateResponse> createGetMyConversionRateResponse(GetMyConversionRateResponse value) {
        return new JAXBElement<GetMyConversionRateResponse>(_GetMyConversionRateResponse_QNAME, GetMyConversionRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyCurrencyCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CurrencyConverter/", name = "getMyCurrencyCodes")
    public JAXBElement<GetMyCurrencyCodes> createGetMyCurrencyCodes(GetMyCurrencyCodes value) {
        return new JAXBElement<GetMyCurrencyCodes>(_GetMyCurrencyCodes_QNAME, GetMyCurrencyCodes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyCurrencyCodesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CurrencyConverter/", name = "getMyCurrencyCodesResponse")
    public JAXBElement<GetMyCurrencyCodesResponse> createGetMyCurrencyCodesResponse(GetMyCurrencyCodesResponse value) {
        return new JAXBElement<GetMyCurrencyCodesResponse>(_GetMyCurrencyCodesResponse_QNAME, GetMyCurrencyCodesResponse.class, null, value);
    }

}
