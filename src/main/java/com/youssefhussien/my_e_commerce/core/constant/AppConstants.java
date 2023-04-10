package com.youssefhussien.my_e_commerce.core.constant;

import java.util.Arrays;
import java.util.List;

public interface AppConstants {
    String baseUrl = "/api/v1";
    List<RoleType> rolesType = Arrays.asList(RoleType.values());
    String ADMIN = "ADMIN";
    String MERCHANT = "MERCHANT";
    String CUSTOMER = "CUSTOMER";

}
