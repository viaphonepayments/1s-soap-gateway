
package com.viaphone.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lookupResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lookupResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchase" type="{http://viaphone.us/soap}Purchase"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookupResponse", namespace = "http://viaphone.us/soap", propOrder = {
    "purchase"
})
public class LookupResponse {

    @XmlElement(namespace = "http://viaphone.us/soap", required = true)
    protected Purchase purchase;

    /**
     * Gets the value of the purchase property.
     * 
     * @return
     *     possible object is
     *     {@link Purchase }
     *     
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * Sets the value of the purchase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Purchase }
     *     
     */
    public void setPurchase(Purchase value) {
        this.purchase = value;
    }

}
