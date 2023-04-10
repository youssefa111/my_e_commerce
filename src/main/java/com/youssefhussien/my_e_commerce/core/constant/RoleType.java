package com.youssefhussien.my_e_commerce.core.constant;

public enum RoleType {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER"),
    MERCHANT("MERCHANT");

    public final String value;
            RoleType(String value){
        this.value = value;
            }
}
