package com.nimbasms.nimbasms.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PurchaseHistoryDto {
    private String uid;
    private String amount;
    @JsonProperty("amount_currency")
    private String amountCurrency;
    private int quantity;
    @JsonProperty("payment_type")
    private String paymentType;
    private String reference;
    @JsonProperty("invoice_pdf")
    private String invoicePdf;
    @JsonProperty("purchase_at")
    private String purchaseAt;
}
