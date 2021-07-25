package com.promotion.devconsole.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Permission {
    DEVELOPER(10), PRODUCT(100), OPERATOR(100), ADMINISTRATOR(1000);

    private final int requestLimit; //request limit per min
}
