package com.example.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
