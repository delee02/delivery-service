package org.delivery.api.domain.user.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.UserSession;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.user.business.UserBusiness;
import org.delivery.api.domain.user.controller.model.User;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user") //로그인 된 사용자가 들어오는 컨트롤러
public class UserApiController {

    private final UserBusiness userBusiness;

   /* @GetMapping("/me")
    public Api<UserResponse> me(){
        var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
        var userId = requestContext.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);

        var response = userBusiness.me(Long.parseLong(userId.toString()));
        return Api.OK(response);
    }*/

    @GetMapping("/me")
   public Api<UserResponse> me(@UserSession User user){
       var response = userBusiness.me(user.getId());
       return Api.OK(response);
   }
}
