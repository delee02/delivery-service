package org.delivery.api.domain.storeMenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.storeMenu.StoreMenuEntity;
import org.delivery.db.storeMenu.StoreMenuRepository;
import org.delivery.db.storeMenu.enums.StoreMenuStatus;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreMenuService {

    private final StoreMenuRepository storeMenuRepository;

    public StoreMenuEntity getStoreMenuWithThrow(Long id){
        var entity = storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED);
        return entity.orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    public List<StoreMenuEntity> getStoreMenuByStoreId(Long id){
        return storeMenuRepository.findAllByStoreIdAndStatusOrderBySequenceDesc(id, StoreMenuStatus.REGISTERED);

    }

    public StoreMenuEntity register(StoreMenuEntity entity){
        return Optional.ofNullable(entity)
                .map(it->{
                    it.setStatus(StoreMenuStatus.REGISTERED);
                    return storeMenuRepository.save(it);
                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }
}
