package com.example.demo.services;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;

}
