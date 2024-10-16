package org.delivery.api.domain.user.converter;

import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.db.user.UserEntity;
import org.delivery.db.user.enums.UserStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
@Component
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request){
        
        return Optional.ofNullable(request)
                .map( it -> {
                    // to entity
                    return UserEntity.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .address(request.getAddress())
                            .build();

                        })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
    }

    public UserResponse toResponse(UserEntity userEntity) {

        return Optional.ofNullable(userEntity)
                .map( it ->{
                    return UserResponse.builder()
                            .id(userEntity.getId())
                            .name(userEntity.getName())
                            .email(userEntity.getEmail())
                            .status(userEntity.getStatus())
                            .address(userEntity.getAddress())
                            .registeredAt(userEntity.getRegisteredAt())
                            .unregisteredAt(userEntity.getUnregisteredAt())
                            .lastLoginAt(userEntity.getLastLoginAt())
                            .build();
                        })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserEntity null"));
    }
}