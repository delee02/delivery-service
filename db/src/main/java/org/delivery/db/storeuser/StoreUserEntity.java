package org.delivery.db.storeuser;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name="store_user")
public class StoreUserEntity extends BaseEntity {

    @Column(nullable = false)
    private Long storeId;

    @Column(length=100,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private StoreUserRole role;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private StoreUserStatus status;

    @Column(length = 100, nullable = false)
    private String password;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime LastLoginAt;
}
