package com.digitalinnovation.personapi.util;

import com.digitalinnovation.personapi.entity.Phone;
import com.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {

    public static Phone toPhone() {
        return Phone.builder()
                .id(1l)
                .number("1199999999")
                .type(PhoneType.MOBILE)
                .build();
    }
}
