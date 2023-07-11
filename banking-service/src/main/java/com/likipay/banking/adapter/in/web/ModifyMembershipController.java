//package com.likipay.banking.adapter.in.web;
//
//import com.likipay.common.WebAdapter;
//import com.likipay.membership.application.port.in.ModifyMemberShipCommand;
//import com.likipay.membership.application.port.in.ModifyMembershipUseCase;
//import com.likipay.membership.domain.Membership;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@WebAdapter
//@RestController
//@RequiredArgsConstructor
//public class ModifyMembershipController {
//
//  private final ModifyMembershipUseCase modifyMembershipUseCase;
//
//  @PutMapping("/membership/register")
//  ResponseEntity<Membership> modifyMembership(@RequestBody ModifyMembershipRequest request) {
//
//    //request~~
//
//    //request -> command
//
//    // usecase -> (request)
//
//    ModifyMemberShipCommand command = ModifyMemberShipCommand.builder()
//        .membershipId(request.getMembershipId())
//        .name(request.getName())
//        .address(request.getAddress())
//        .email(request.getEmail())
//        .isValid(true)
//        .isCorp(request.isCorp())
//        .build();
//
//    return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
//
//  }
//}
