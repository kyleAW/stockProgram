
package org.myws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.myws package. 
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

    private final static QName _AllStocks_QNAME = new QName("http://myws.org/", "allStocks");
    private final static QName _AllStocksResponse_QNAME = new QName("http://myws.org/", "allStocksResponse");
    private final static QName _DateOrder_QNAME = new QName("http://myws.org/", "dateOrder");
    private final static QName _DateOrderResponse_QNAME = new QName("http://myws.org/", "dateOrderResponse");
    private final static QName _PriceOrder_QNAME = new QName("http://myws.org/", "priceOrder");
    private final static QName _PriceOrderResponse_QNAME = new QName("http://myws.org/", "priceOrderResponse");
    private final static QName _SearchStock_QNAME = new QName("http://myws.org/", "searchStock");
    private final static QName _SearchStockResponse_QNAME = new QName("http://myws.org/", "searchStockResponse");
    private final static QName _ShareBuy_QNAME = new QName("http://myws.org/", "shareBuy");
    private final static QName _ShareBuyResponse_QNAME = new QName("http://myws.org/", "shareBuyResponse");
    private final static QName _ShareOrder_QNAME = new QName("http://myws.org/", "shareOrder");
    private final static QName _ShareOrderResponse_QNAME = new QName("http://myws.org/", "shareOrderResponse");
    private final static QName _ShareSell_QNAME = new QName("http://myws.org/", "shareSell");
    private final static QName _ShareSellResponse_QNAME = new QName("http://myws.org/", "shareSellResponse");
    private final static QName _UpdatePrices_QNAME = new QName("http://myws.org/", "updatePrices");
    private final static QName _UpdatePricesResponse_QNAME = new QName("http://myws.org/", "updatePricesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.myws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AllStocks }
     * 
     */
    public AllStocks createAllStocks() {
        return new AllStocks();
    }

    /**
     * Create an instance of {@link AllStocksResponse }
     * 
     */
    public AllStocksResponse createAllStocksResponse() {
        return new AllStocksResponse();
    }

    /**
     * Create an instance of {@link DateOrder }
     * 
     */
    public DateOrder createDateOrder() {
        return new DateOrder();
    }

    /**
     * Create an instance of {@link DateOrderResponse }
     * 
     */
    public DateOrderResponse createDateOrderResponse() {
        return new DateOrderResponse();
    }

    /**
     * Create an instance of {@link PriceOrder }
     * 
     */
    public PriceOrder createPriceOrder() {
        return new PriceOrder();
    }

    /**
     * Create an instance of {@link PriceOrderResponse }
     * 
     */
    public PriceOrderResponse createPriceOrderResponse() {
        return new PriceOrderResponse();
    }

    /**
     * Create an instance of {@link SearchStock }
     * 
     */
    public SearchStock createSearchStock() {
        return new SearchStock();
    }

    /**
     * Create an instance of {@link SearchStockResponse }
     * 
     */
    public SearchStockResponse createSearchStockResponse() {
        return new SearchStockResponse();
    }

    /**
     * Create an instance of {@link ShareBuy }
     * 
     */
    public ShareBuy createShareBuy() {
        return new ShareBuy();
    }

    /**
     * Create an instance of {@link ShareBuyResponse }
     * 
     */
    public ShareBuyResponse createShareBuyResponse() {
        return new ShareBuyResponse();
    }

    /**
     * Create an instance of {@link ShareOrder }
     * 
     */
    public ShareOrder createShareOrder() {
        return new ShareOrder();
    }

    /**
     * Create an instance of {@link ShareOrderResponse }
     * 
     */
    public ShareOrderResponse createShareOrderResponse() {
        return new ShareOrderResponse();
    }

    /**
     * Create an instance of {@link ShareSell }
     * 
     */
    public ShareSell createShareSell() {
        return new ShareSell();
    }

    /**
     * Create an instance of {@link ShareSellResponse }
     * 
     */
    public ShareSellResponse createShareSellResponse() {
        return new ShareSellResponse();
    }

    /**
     * Create an instance of {@link UpdatePrices }
     * 
     */
    public UpdatePrices createUpdatePrices() {
        return new UpdatePrices();
    }

    /**
     * Create an instance of {@link UpdatePricesResponse }
     * 
     */
    public UpdatePricesResponse createUpdatePricesResponse() {
        return new UpdatePricesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllStocks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "allStocks")
    public JAXBElement<AllStocks> createAllStocks(AllStocks value) {
        return new JAXBElement<AllStocks>(_AllStocks_QNAME, AllStocks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllStocksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "allStocksResponse")
    public JAXBElement<AllStocksResponse> createAllStocksResponse(AllStocksResponse value) {
        return new JAXBElement<AllStocksResponse>(_AllStocksResponse_QNAME, AllStocksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "dateOrder")
    public JAXBElement<DateOrder> createDateOrder(DateOrder value) {
        return new JAXBElement<DateOrder>(_DateOrder_QNAME, DateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "dateOrderResponse")
    public JAXBElement<DateOrderResponse> createDateOrderResponse(DateOrderResponse value) {
        return new JAXBElement<DateOrderResponse>(_DateOrderResponse_QNAME, DateOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "priceOrder")
    public JAXBElement<PriceOrder> createPriceOrder(PriceOrder value) {
        return new JAXBElement<PriceOrder>(_PriceOrder_QNAME, PriceOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "priceOrderResponse")
    public JAXBElement<PriceOrderResponse> createPriceOrderResponse(PriceOrderResponse value) {
        return new JAXBElement<PriceOrderResponse>(_PriceOrderResponse_QNAME, PriceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "searchStock")
    public JAXBElement<SearchStock> createSearchStock(SearchStock value) {
        return new JAXBElement<SearchStock>(_SearchStock_QNAME, SearchStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "searchStockResponse")
    public JAXBElement<SearchStockResponse> createSearchStockResponse(SearchStockResponse value) {
        return new JAXBElement<SearchStockResponse>(_SearchStockResponse_QNAME, SearchStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareBuy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareBuy")
    public JAXBElement<ShareBuy> createShareBuy(ShareBuy value) {
        return new JAXBElement<ShareBuy>(_ShareBuy_QNAME, ShareBuy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareBuyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareBuyResponse")
    public JAXBElement<ShareBuyResponse> createShareBuyResponse(ShareBuyResponse value) {
        return new JAXBElement<ShareBuyResponse>(_ShareBuyResponse_QNAME, ShareBuyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareOrder")
    public JAXBElement<ShareOrder> createShareOrder(ShareOrder value) {
        return new JAXBElement<ShareOrder>(_ShareOrder_QNAME, ShareOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareOrderResponse")
    public JAXBElement<ShareOrderResponse> createShareOrderResponse(ShareOrderResponse value) {
        return new JAXBElement<ShareOrderResponse>(_ShareOrderResponse_QNAME, ShareOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareSell }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareSell")
    public JAXBElement<ShareSell> createShareSell(ShareSell value) {
        return new JAXBElement<ShareSell>(_ShareSell_QNAME, ShareSell.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareSellResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "shareSellResponse")
    public JAXBElement<ShareSellResponse> createShareSellResponse(ShareSellResponse value) {
        return new JAXBElement<ShareSellResponse>(_ShareSellResponse_QNAME, ShareSellResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePrices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "updatePrices")
    public JAXBElement<UpdatePrices> createUpdatePrices(UpdatePrices value) {
        return new JAXBElement<UpdatePrices>(_UpdatePrices_QNAME, UpdatePrices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePricesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws.org/", name = "updatePricesResponse")
    public JAXBElement<UpdatePricesResponse> createUpdatePricesResponse(UpdatePricesResponse value) {
        return new JAXBElement<UpdatePricesResponse>(_UpdatePricesResponse_QNAME, UpdatePricesResponse.class, null, value);
    }

}
