package org.delivery.api.domain.store.converter;

import jakarta.persistence.Converter;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.db.store.StoreEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Converter
@Component
public class StoreConverter {

    public StoreEntity toEntity(StoreRegisterRequest request){
        return Optional.ofNullable(request)
                .map(it->{
                    return StoreEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .thumbnailUrl(request.getThumbnailUrl())
                .category(request.getStoreCategory())
                .minimumAmount(request.getMinimumAmount())
                .minimumDeliveryAmount(request.getMinimumDeliveryAmount())
                .phoneNumber(request.getPhoneNumber())
                .build();
                }).orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));

    }

    public StoreResponse toResponse(StoreEntity entity){
        return Optional.ofNullable(entity)
                .map(it -> {
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
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
