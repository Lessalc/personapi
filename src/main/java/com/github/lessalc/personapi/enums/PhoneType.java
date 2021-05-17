package com.github.lessalc.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor  // PESQUISAR PARA ENTENDER
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMERCIAL("Commercial");

    private final String description;
}