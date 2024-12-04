package org.delivery.api.domain.userordermenu.converter;


import jakarta.persistence.Converter;
import org.delivery.db.storeMenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.springframework.stereotype.Component;

@Converter
@Component

public class UserOrderMenuConverter {

    public UserOrderMenuEntity toEntity(
            UserOrderEntity userOrderEntity,
            StoreMenuEntity storeMenuEntity
    ){
        return UserOrderMenuEntity.builder()
                .userOrderId(userOrderEntity.getId())
                .storeMenuId(storeMenuEntity.getId())
                .build();
    }
}
