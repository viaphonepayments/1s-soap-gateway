
package com.viaphone.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productItems" type="{http://viaphone.us/soap}PurchaseItems"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productItems"
})
@XmlRootElement(name = "createPurchaseRequest", namespace = "http://viaphone.us/soap")
public class CreatePurchaseRequest {

    @XmlElement(namespace = "http://viaphone.us/soap", required = true)
    protected PurchaseItems productItems;

    /**
     * Gets the value of the productItems property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseItems }
     *     
     */
    public PurchaseItems getProductItems() {
        return productItems;
    }

    /**
     * Sets the value of the productItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseItems }
     *     
     */
    public void setProductItems(PurchaseItems value) {
        this.productItems = value;
    }

}
