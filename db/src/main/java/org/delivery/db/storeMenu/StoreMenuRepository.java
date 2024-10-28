package org.delivery.db.storeMenu;

import org.delivery.db.storeMenu.enums.StoreMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreMenuRepository extends JpaRepository {

    //유효한 메뉴 가져오기
    //select * from store_menu where id=? and status = ? order by id desc limit 1
    Optional<StoreMenuRepository> findFirstByIdAndStatusOrderByIdDESC(Long id, StoreMenuStatus status);


    //특정 가게 메뉴 가져오기
    //selec * from store_menu where store_id=? and status=? order by sequence desc
    List<StoreMenuEntity> findAllByStoreIdAndStatusOrderBySequenceDESC(Long store_id, StoreMenuStatus status);
}
