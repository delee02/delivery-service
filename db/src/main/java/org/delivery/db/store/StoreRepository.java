package org.delivery.db.store;

import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
    //id + status
    //select * from store where id=? and status=? order by id limit 1
    Optional<StoreEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, StoreStatus status);

    //유효한 스토어 리스트
    //select * from store where status = ? order by id desc
    List<StoreEntity> findAllByStatusOrderByIdDesc(StoreStatus status);

    //유효한 특정 카테고리의 스토어 리스트 (졸아요 많은 순)
    //select * from store where categoty=? and status=? order by star desc
    List<StoreEntity> findAllByCategoryAndStatusOrderByStarDesc(StoreCategory category, StoreStatus status);


    //select * from store where name=? and status=? order by id desc
    Optional<StoreEntity> findFirstByNameAndStatusOrderByIdDesc(String name, StoreStatus status);
}
