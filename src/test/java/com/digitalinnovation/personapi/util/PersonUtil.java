package com.digitalinnovation.personapi.util;

import com.digitalinnovation.personapi.entity.Person;
import org.assertj.core.api.AbstractLocalDateTimeAssert;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtil {

    public static Person toPerson(){
        return Person.builder()
                .id(1L)
                .firstName("Ana")
                .lastName("maria")
                .cpf("123456789-11")
                .birthDate(LocalDate.of(1993, 8, 19))
                .phones(Collections.singletonList(PhoneUtils.toPhone()))
                .build();
    }
}
