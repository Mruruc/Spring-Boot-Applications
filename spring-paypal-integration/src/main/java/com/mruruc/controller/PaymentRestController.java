package com.mruruc.controller;

import com.mruruc.dto.PaymentDto;
import com.mruruc.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {
    private final PaypalService paypalService;

    public PaymentRestController(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<URI> paymentRest(@RequestBody PaymentDto paymentDto) {

        try {
            Payment payment = paypalService.createPayment(paymentDto.getAmount(), paymentDto.getCurrency(),
                    paymentDto.getMethod(), "sale", paymentDto.getDescription());

            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.status(HttpStatus.OK).body(URI.create(links.getHref()));
                }
            }
        } catch (PayPalRESTException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/success")
    public ResponseEntity<String> paymentSuccessRest(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {

        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return ResponseEntity.status(HttpStatus.OK).body("Payment successful");
            }
        } catch (PayPalRESTException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during payment execution");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment not approved");
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> paymentCancelRest() {
        return ResponseEntity.status(HttpStatus.OK).body("Payment canceled");
    }

    @GetMapping("/error")
    public ResponseEntity<String> errorRest() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the payment process");
    }
}
