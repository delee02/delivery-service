package org.delivery.api.domain.storeMenu.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreMenuRegisterRequest {

    @NotNull
    private Long storeId;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String thumbnailUrl;
}
