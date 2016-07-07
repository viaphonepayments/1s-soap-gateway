package com.viaphone.soap;

import com.viaphone.sdk.MerchantSdk;
import com.viaphone.sdk.model.*;
import com.viaphone.sdk.model.merchant.LookupResp;
import com.viaphone.soap.model.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Endpoint
public class MerchantEndpoint {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final String NAMESPACE_URI = "http://viaphone.us/soap";
    private MerchantSdk merchantSdk;

    public MerchantEndpoint(String merchantKey, String merchantSecret) throws Exception {
        merchantSdk = new MerchantSdk(merchantKey, merchantSecret, null);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "lookupRequest")
    @ResponsePayload
    public LookupRequestResponse lookupRequest(@RequestPayload LookupRequest request) throws IOException {
        System.out.println("Request:" + request.getPurchaseId());
        LookupResp apiResp = merchantSdk.lookupPurchase(Long.parseLong(request.getPurchaseId()));
        LookupResponse response = new LookupResponse();
        response.setPurchase(convertPurchase(apiResp.getPurchase()));
        LookupRequestResponse resp = new LookupRequestResponse();
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
//        p.setSecret("asd");
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
            item.setPrice((float) pi.getPrice());
            item.setDiscount((float) pi.getDiscount());
            item.setType(pi.getType());
            items.add(item);
        });
    }
}
