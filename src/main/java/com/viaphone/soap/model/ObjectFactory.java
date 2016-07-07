
package com.viaphone.soap.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.viaphone.soap.model package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.viaphone.soap.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LookupRequestResponse }
     * 
     */
    public LookupRequestResponse createLookupRequestResponse() {
        return new LookupRequestResponse();
    }

    /**
     * Create an instance of {@link LookupResponse }
     * 
     */
    public LookupResponse createLookupResponse() {
        return new LookupResponse();
    }

    /**
     * Create an instance of {@link LookupRequest }
     * 
     */
    public LookupRequest createLookupRequest() {
        return new LookupRequest();
    }

    /**
     * Create an instance of {@link Purchase }
     * 
     */
    public Purchase createPurchase() {
        return new Purchase();
    }

    /**
     * Create an instance of {@link PurchaseItem }
     * 
     */
    public PurchaseItem createPurchaseItem() {
        return new PurchaseItem();
    }

}
