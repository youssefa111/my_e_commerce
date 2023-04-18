package com.youssefhussien.my_e_commerce.core.constant;

public enum PaymentProvider {
    CASH("CASH"),
    VISA("VISA");

    public final String value;
    PaymentProvider(String value){
        this.value = value;
    }
}