//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.24 at 08:47:44 PM GMT 
//


package stocks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stockType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shareNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stock_price" type="{http://xml.netbeans.org/schema/Shares}stockPrice"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stockType", propOrder = {
    "name",
    "code",
    "shareNo",
    "stockPrice"
})
public class StockType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String code;
    protected int shareNo;
    @XmlElement(name = "stock_price", required = true)
    protected StockPrice stockPrice;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the shareNo property.
     * 
     */
    public int getShareNo() {
        return shareNo;
    }

    /**
     * Sets the value of the shareNo property.
     * 
     */
    public void setShareNo(int value) {
        this.shareNo = value;
    }

    /**
     * Gets the value of the stockPrice property.
     * 
     * @return
     *     possible object is
     *     {@link StockPrice }
     *     
     */
    public StockPrice getStockPrice() {
        return stockPrice;
    }

    /**
     * Sets the value of the stockPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockPrice }
     *     
     */
    public void setStockPrice(StockPrice value) {
        this.stockPrice = value;
    }

}
