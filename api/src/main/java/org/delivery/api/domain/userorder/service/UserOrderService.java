package org.delivery.api.domain.userorder.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userorder.UserOrderRepository;
import org.delivery.db.userorder.enums.UserOrderStatus;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;

    public UserOrderEntity getUserOrderWithoutStatusThrow(Long id, Long userId){
        return userOrderRepository.findAllByIdAndUserId(id, userId)
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    public UserOrderEntity getUserOrderWithThrow(Long id, Long userId){
        return userOrderRepository.findAllByIdAndStatusAndUserId(id, UserOrderStatus.REGISTERED, userId)
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }


    public List<UserOrderEntity> getUserOrderList (Long userId){
        return userOrderRepository.findAllByUserIdAndStatusOrderByIdDesc(userId, UserOrderStatus.REGISTERED);
    }

    public List<UserOrderEntity> getUserOrderList (Long userId, List<UserOrderStatus> statusList){
        return userOrderRepository.findAllByUserIdAndStatusInOrderByIdDesc(userId, statusList);
    }

    //현재 주문중인
    public List<UserOrderEntity> current(Long userId){
        return getUserOrderList(
                userId,
                List.of(
                        UserOrderStatus.ORDER,
                        UserOrderStatus.ACCEPT,
                        UserOrderStatus.COOKING,
                        UserOrderStatus.DELIVERY
                )
        );
    }

    //과거 주문 내역
    public List<UserOrderEntity> history(Long userId){
        return getUserOrderList(
                userId,
                List.of(
                        UserOrderStatus.RECEIVE
                )
        );
    }

    //주문(create)
    public UserOrderEntity order(UserOrderEntity userOrderEntity){
        return Optional.ofNullable(userOrderEntity)
                .map(it->{
                    it.setStatus(UserOrderStatus.ORDER);
                    it.setOrderedAt(LocalDateTime.now());
                    return userOrderRepository.save(it);
                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    //상태변경
    public UserOrderEntity setStatus(UserOrderEntity userOrderEntity, UserOrderStatus userOrderStatus){
        userOrderEntity.setStatus(userOrderStatus);
        return userOrderRepository.save(userOrderEntity);
    }

    //수락
    public UserOrderEntity accept(UserOrderEntity userOrderEntity){
        userOrderEntity.setAcceptedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.ACCEPT);
    }

    //조리시작
    public UserOrderEntity cooking(UserOrderEntity userOrderEntity){
        userOrderEntity.setCookingStartedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.COOKING);
    }

    //배달중

    public UserOrderEntity delivery(UserOrderEntity userOrderEntity){
        userOrderEntity.setDeliveryStartedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.DELIVERY);
    }

    //완료
    public UserOrderEntity receive(UserOrderEntity userOrderEntity){
        userOrderEntity.setReceivedAt(LocalDateTime.now());

        return setStatus(userOrderEntity, UserOrderStatus.RECEIVE);
    }
}
