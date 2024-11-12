package org.delivery.db.userorder.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserOrderStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지"),
    ORDER("주문"),
    ACCPEPT("수락"),
    COOKING("요리중"),
    DELIVERY("배달중"),
    REVEIVE("완료")
    ;
    private final String description;
}
