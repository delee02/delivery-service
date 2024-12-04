package org.delivery.api.domain.userorder.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderRequest {

    //주문
    //특정 사용자(로그인 된 세션에 들어있는 사용자)가 특정 메뉴 주문
    //특정 메뉴 id

    //로그인 되있는 사용자를 쓸거기때문에 아디 필요 ㄴㄴ
    @NotNull
    private List<Long> storeMenuIdList;
}
