package com.likipay.membership.adapter.in.web;

import common.WebAdapter;
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


  @PostMapping("/membership/register")
  void registerMembership(@RequestBody RegisterMembershipRequest request) {

    //request~~

    //request -> command

    // usecase -> (request)
  }
}
