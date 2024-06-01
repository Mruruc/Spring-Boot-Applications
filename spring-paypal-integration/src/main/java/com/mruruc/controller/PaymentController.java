package com.mruruc.controller;

import com.mruruc.dto.PaymentDto;
import com.mruruc.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class PaymentController {
    private final PaypalService paypalService;

    public PaymentController(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/payment/create")
    public RedirectView payment(@ModelAttribute PaymentDto paymentDto) {
        try {
            Payment payment =
                    paypalService.createPayment(
                            paymentDto.getAmount(),
                            paymentDto.getCurrency(),
                            paymentDto.getMethod(), "sale",
                            paymentDto.getDescription());


            for (Links links : payment.getLinks()) {
                if(links.getRel().equals("approval_url")){
                    return new RedirectView(links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            log.error("Error happened during payment creation!::", e);
        }
        return new RedirectView("/payment/error");
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try{

            Payment payment = paypalService.executePayment(paymentId, payerId);

            if(payment.getState().equals("approved")){
                return "paymentSuccess";
            }

        }catch (PayPalRESTException e) {
            log.error("Error happened during payment!::", e);
        }
        return "paymentSuccess";
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel() {
        return "payment-cancel";
    }

    @GetMapping("/payment/error")
    public String error() {
        return "error-page";
    }



}
