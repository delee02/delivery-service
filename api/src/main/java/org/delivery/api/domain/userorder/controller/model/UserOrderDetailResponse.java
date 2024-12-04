package org.delivery.api.domain.userorder.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.domain.storeMenu.controller.model.StoreMenuResponse;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDetailResponse {

    private UserOrderResponse userOrderResponse;

    private StoreMenuResponse storeMenuResponse;

    private List<StoreMenuResponse> storeMenuResponseList;
}
