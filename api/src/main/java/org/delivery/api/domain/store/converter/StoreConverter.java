package org.delivery.api.domain.store.converter;

import jakarta.persistence.Converter;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.db.store.StoreEntity;
import org.springframework.stereotype.Component;

@Converter
@Component
public class StoreConverter {

    public StoreEntity toEntity(StoreRegisterRequest request){
        return StoreEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .thumbnailUrl(request.getThumbnailUrl())
                .category(request.getStoreCategory())
                .minimumAmount(request.getMinimumAmount())
                .minimumDeliveryAmount(request.getMinimumDeliveryAmount())
                .phoneNumber(request.getPhoneNumber())
                .build();

    }

    public StoreResponse toResponse(StoreEntity entity){
        return StoreResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .address(entity.getAddress())
                .thumbnailUrl(entity.getThumbnailUrl())
                .category(entity.getCategory())
                .minimumDeliveryAmount(entity.getMinimumDeliveryAmount())
                .minimumAmount(entity.getMinimumAmount())
                .phoneNumber(entity.getPhoneNumber())
                .star(entity.getStar())
                .build();
    }
}
