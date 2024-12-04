package org.delivery.api.domain.userorder.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.storeMenu.service.StoreMenuService;
import org.delivery.api.domain.user.controller.model.User;
import org.delivery.api.domain.userorder.controller.model.UserOrderDetailResponse;
import org.delivery.api.domain.userorder.controller.model.UserOrderResponse;
import org.delivery.api.domain.userorder.converter.UserOrderConverter;
import org.delivery.api.domain.userorder.controller.model.UserOrderRequest;
import org.delivery.api.domain.userorder.service.UserOrderService;
import org.delivery.api.domain.userordermenu.converter.UserOrderMenuConverter;
import org.delivery.api.domain.userordermenu.service.UserOrderMenuService;
import org.delivery.db.store.StoreEntity;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Business
public class UserOrderBusiness {

    private final UserOrderService userOrderService;

    private final StoreMenuService storeMenuService;

    private final UserOrderConverter userOrderConverter;

    private final UserOrderMenuConverter userOrderMenuConverter;

    private final UserOrderMenuService userOrderMenuService;
    //사용자, 메뉴id
    //userOrder 생성
    //userOrderMenu 생성
    //응답 생성

    public UserOrderResponse userOrder(User user, UserOrderRequest request){

        var storeMenuEntityList = request.getStoreMenuIdList()
                .stream()
                .map(it -> storeMenuService.getStoreMenuWithThrow(it))
                .collect(Collectors.toList());

        var userOrderEntity = userOrderConverter.toEntity(user, storeMenuEntityList);

        //주문
        var newUserOrderEntity = userOrderService.order(userOrderEntity);

        //맵핑
        var userOrderMenuEntityList = storeMenuEntityList.stream()
                .map(it->{
                    //menu + user order
                    var userOrderMenuEntity = userOrderMenuConverter.toEntity(newUserOrderEntity, it);

                    return userOrderMenuEntity;
                })
                .collect(Collectors.toList());

        //주문내역 기록남기기
        userOrderMenuEntityList.forEach(
                it ->{userOrderMenuService.order(it);
                });

        return userOrderConverter.toResponse(newUserOrderEntity);
    }

    public List<UserOrderDetailResponse> current(User user) {
        var userOrderEntityList = userOrderService.current(user.getId());

        //주문 한건씩 처리
        userOrderEntityList.stream().map(it->{
            var storeEntity = new StoreEntity();

            //사용자가 주문한 메뉴
            var userOrderMenuEntityList = userOrderMenuService.getGetUserOrderMenu(it.getId());
                })
                .collect(Collectors.toList());
    }
}
