
package com.viaphone.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PurchaseStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="purchaseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseStatusResponse", namespace = "http://viaphone.us/soap", propOrder = {
    "purchaseStatus",
    "purchaseId"
})
public class PurchaseStatusResponse {

    @XmlElement(namespace = "http://viaphone.us/soap", required = true)
    protected String purchaseStatus;
    @XmlElement(namespace = "http://viaphone.us/soap")
    protected long purchaseId;

    /**
     * Gets the value of the purchaseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    /**
     * Sets the value of the purchaseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseStatus(String value) {
        this.purchaseStatus = value;
    }

    /**
     * Gets the value of the purchaseId property.
     * 
     */
    public long getPurchaseId() {
        return purchaseId;
    }

    /**
     * Sets the value of the purchaseId property.
     * 
     */
    public void setPurchaseId(long value) {
        this.purchaseId = value;
    }

}
