package org.delivery.storeadmin.domain.storeuser.controller.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreUserResponse {

    private UserResponse user;

    private StoreResponse store;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserResponse{
        private Long id;

        private String email;

        private StoreUserRole role;

        private StoreUserStatus status;

        private LocalDateTime registeredAt;

        private LocalDateTime unregisteredAt;

        private LocalDateTime lastLoginAt;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class StoreResponse{

        private Long id;

        private String name;

    }
}
