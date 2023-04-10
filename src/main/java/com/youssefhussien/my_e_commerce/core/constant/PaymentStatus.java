package com.youssefhussien.my_e_commerce.core.constant;

public enum PaymentStatus {
    PAID(1),
    UNPAID(0);

    public final int value;
    private PaymentStatus(int value) {
        this.value = value;
    }
}
