package com.likipay.banking.adapter.in.web;

import com.likipay.common.WebAdapter;
import com.likipay.membership.application.port.in.RegisterMemberShipCommand;
import com.likipay.membership.application.port.in.RegisterMembershipUseCase;
import com.likipay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

  @GetMapping("/test")
  public void test() {

    System.out.println("hello world!");
  }


  private final RegisterMembershipUseCase registerMembershipUseCase;

  @PostMapping("/membership/register")
  Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

    //request~~

    //request -> command

    // usecase -> (request)

    RegisterMemberShipCommand command = RegisterMemberShipCommand.builder()
        .name(request.getName())
        .address(request.getAddress())
        .email(request.getEmail())
        .isValid(true)
        .isCorp(request.isCorp())
        .build();

    return registerMembershipUseCase.registerMembership(command);

  }
}
