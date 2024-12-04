package org.delivery.api.domain.userorder.converter;

import jakarta.persistence.Converter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.delivery.api.domain.user.controller.model.User;
import org.delivery.api.domain.userorder.controller.model.UserOrderResponse;
import org.delivery.db.storeMenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userorder.enums.UserOrderStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Converter
@Component
@RequiredArgsConstructor
public class UserOrderConverter {

    public UserOrderEntity toEntity(
            User user,
            List<StoreMenuEntity> storeMenuEntityList
    ){
        var totalAmount = storeMenuEntityList.stream()
                .map(it -> it.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return UserOrderEntity.builder()
                .userId(user.getId())
                .amount(totalAmount)
                .build();
    }

    public UserOrderResponse toResponse(
            UserOrderEntity userOrderEntity
    ){
        return UserOrderResponse.builder()
                .id(userOrderEntity.getId())
                .status(userOrderEntity.getStatus())
                .orderedAt(userOrderEntity.getOrderedAt())
                .acceptedAt(userOrderEntity.getAcceptedAt())
                .cookingStartedAt(userOrderEntity.getCookingStartedAt())
                .amount(userOrderEntity.getAmount())
                .deliveryStartedAt(userOrderEntity.getDeliveryStartedAt())
                .receivedAt(userOrderEntity.getReceivedAt())
                .build();
    }
}
