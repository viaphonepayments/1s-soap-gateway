package com.viaphone.soap;

import com.viaphone.sdk.MerchantSdk;
import com.viaphone.sdk.model.*;
import com.viaphone.sdk.model.merchant.*;
import com.viaphone.soap.model.*;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class MerchantEndpoint {

    private static final Logger log = Logger.getLogger(MerchantEndpoint.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final String NAMESPACE_URI = "http://viaphone.us/soap";
    private MerchantSdk merchantSdk;

    public MerchantEndpoint(String merchantKey, String merchantSecret) throws Exception {
        merchantSdk = new MerchantSdk(merchantKey, merchantSecret, null);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPurchaseRequest")
    @ResponsePayload
    public CreatePurchaseRequestResponse createPurchaseRequest(@RequestPayload CreatePurchaseRequest req) throws IOException {
        CreatePurchaseRequestResponse resp = new CreatePurchaseRequestResponse();
        List<ProductItem> productItems = convertProductItems(req.getProductItems());
        if (productItems == null) {
            log.error("Got createPurchaseRequest with empty products");
            return resp;
        }

        log.info("Got createPurchaseRequest: " + productItems);
        CreateResp apiResp = merchantSdk.createPurchase(productItems);
        log.info("Sdk response: " + apiResp.toString());
        CreatePurchaseResponse response = new CreatePurchaseResponse();
        response.setPurchaseId(apiResp.getPurchaseId());
        response.setPurchaseStatus(apiResp.getPurchaseStatus().name());
        response.setToken(apiResp.getToken());
        response.setQr(apiResp.getQr());
        resp.setReturn(response);
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "lookupRequest")
    @ResponsePayload
    public LookupRequestResponse lookupRequest(@RequestPayload LookupRequest request) throws IOException {
        log.info("Got lookupRequest: " + request.getPurchaseId());
        LookupResp apiResp = merchantSdk.lookupPurchase(request.getPurchaseId());
        log.info("Sdk response: " + apiResp.toString());
        LookupResponse response = new LookupResponse();
        response.setPurchase(convertPurchase(apiResp.getPurchase()));
        LookupRequestResponse resp = new LookupRequestResponse();
        resp.setReturn(response);
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "purchaseStatusRequest")
    @ResponsePayload
    public PurchaseStatusRequestResponse purchaseStatusRequest(@RequestPayload PurchaseStatusRequest request) throws IOException {
        log.info("Got purchaseStatusRequest: " + request.getPurchaseId());
        PurchaseStatusResp apiResp = merchantSdk.getPurchaseStatus(request.getPurchaseId());
        log.info("Sdk response: " + apiResp.toString());
        PurchaseStatusResponse response = new PurchaseStatusResponse();
        response.setPurchaseStatus(apiResp.getPurchaseStatus().name());
        PurchaseStatusRequestResponse resp = new PurchaseStatusRequestResponse();
        resp.setReturn(response);
        return resp;
    }

    private Purchase convertPurchase(CustomerPurchase purchase) {
        Purchase p = new Purchase();
        p.setId(purchase.getId());
        p.setBranchName(purchase.getBranchName());
        p.setStoreName(purchase.getStoreName());
        p.setAmount(purchase.getAmount().floatValue());
        p.setDiscount(purchase.getDiscount().floatValue());
        p.setCreated(dateFormat.format(purchase.getCreated()));
        p.setCompleted(dateFormat.format(purchase.getCompleted()));
        fillPurchaseItem(p, purchase.getProducts());
        return p;
    }

    private void fillPurchaseItem(Purchase purchase, List<ProductItem> productItems) {
        List<PurchaseItem> items = purchase.getProducts();
        productItems.forEach(pi -> {
            PurchaseItem item = new PurchaseItem();
            item.setBarCode(pi.getBarCode());
            item.setName(pi.getName());
            item.setCategory(pi.getCategory());
            item.setBrand(pi.getBrand());
            item.setQty(pi.getQty());
            item.setPrice(pi.getPrice().floatValue());
            item.setDiscount(pi.getDiscount().floatValue());
            item.setType(pi.getType());
            items.add(item);
        });
    }

    private List<ProductItem> convertProductItems(PurchaseItems purchaseItems) {
        if (purchaseItems != null && !purchaseItems.getProducts().isEmpty()) {
            List<ProductItem> items = new ArrayList<>();
            purchaseItems.getProducts().forEach(pi -> {
                ProductItem item = new ProductItem();
                item.setBarCode(pi.getBarCode());
                item.setName(pi.getName());
                item.setCategory(pi.getCategory());
                item.setBrand(pi.getBrand());
                item.setType(pi.getType());
                item.setQty(pi.getQty());
                item.setPrice(pi.getPrice().doubleValue());
                items.add(item);
            });
            return items;
        }
        return null;
    }
}
