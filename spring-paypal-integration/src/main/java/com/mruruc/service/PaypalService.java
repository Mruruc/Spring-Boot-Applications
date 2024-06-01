package com.mruruc.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PaypalService {
    @Value("${paypal.url.cancel}")
    private  String cancelUrl;
    @Value("${paypal.url.success}")
    private  String successUrl;

    private final APIContext apiContext;

    @Autowired
    public PaypalService(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    public Payment createPayment(Double total,String currency,String method,
                                 String intent,String description) throws PayPalRESTException {
          // Amount
        Amount amount = this.amount(currency,total);

        // get transactions
        List<Transaction> transactions = this.transactions(description, amount);

        // Payer
        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        // payment
        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        // Redirect URLs
        RedirectUrls redirectUrls = this.redirectUrls(payment);

        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId,String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);

        return payment.execute(apiContext,paymentExecute);
    }


    private RedirectUrls redirectUrls( Payment payment) {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(this.cancelUrl);
        redirectUrls.setReturnUrl(this.successUrl);
        return redirectUrls;
    }

    private Amount amount(String currency,Double total){
        Amount amount =new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format(Locale.forLanguageTag(currency),"%.2f",total));
        return amount;
    }
    private List<Transaction> transactions(String description,Amount amount){
        // Transaction information
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        // Add transaction to a list
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        return transactions;
    }
}
