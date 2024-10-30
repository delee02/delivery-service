package org.delivery.api.domain.storeMenu.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.storeMenu.controller.model.StoreMenuRegisterRequest;
import org.delivery.api.domain.storeMenu.controller.model.StoreMenuResponse;
import org.delivery.api.domain.storeMenu.converter.StoreMenuConverter;
import org.delivery.api.domain.storeMenu.service.StoreMenuService;
import org.delivery.db.storeMenu.StoreMenuRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Business
public class StoreMenuBusiness {
    
    private final StoreMenuService storeMenuService;
    private final StoreMenuConverter storeMenuConverter;
    
    public StoreMenuResponse register(StoreMenuRegisterRequest request){
        //req -> entity -> save -> response
        var entity = storeMenuConverter.toEntity(request);
        var newEntity = storeMenuService.register(entity);
        var response = storeMenuConverter.toResponse(newEntity);

        return response;
    }

    //특정가게 메뉴 가져오기
    public List<StoreMenuResponse> search(Long storeId){
        var list = storeMenuService.getStoreMenuByStoreId(storeId);

        return list.stream()
                .map(it -> {
                    return storeMenuConverter.toResponse(it);
                })
                //map(storeConverter::toResponse)
                .collect(Collectors.toList());
    }
}
