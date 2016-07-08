
package com.viaphone.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreatePurchaseResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreatePurchaseResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchaseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="purchaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatePurchaseResponse", namespace = "http://viaphone.us/soap", propOrder = {
    "purchaseId",
    "purchaseStatus",
    "token",
    "qr"
})
public class CreatePurchaseResponse {

    @XmlElement(namespace = "http://viaphone.us/soap")
    protected long purchaseId;
    @XmlElement(namespace = "http://viaphone.us/soap", required = true)
    protected String purchaseStatus;
    @XmlElement(namespace = "http://viaphone.us/soap")
    protected String token;
    @XmlElement(namespace = "http://viaphone.us/soap")
    protected String qr;

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
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the qr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQr() {
        return qr;
    }

    /**
     * Sets the value of the qr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQr(String value) {
        this.qr = value;
    }

}
