
package org.netbeans.xml.schema.shares;

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
 * &lt;complexType name="stockType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="shareNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="stock_price" type="{http://xml.netbeans.org/schema/Shares}stockPrice"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
