package org.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreStatus {
//대기 ,  해지신청 등의 상태가 더 있을 수 있음
    REGISTERED("등록"),

    UNREGISTERED("해지"),
    ;

    private String description;
}
