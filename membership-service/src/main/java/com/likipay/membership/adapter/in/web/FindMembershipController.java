package com.likipay.membership.adapter.in.web;

import com.likipay.membership.application.port.in.FindMembershipCommand;
import com.likipay.membership.application.port.in.FindMembershipUseCase;
import com.likipay.membership.domain.Membership;
import com.likipay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

  private final FindMembershipUseCase findMembershipUseCase;

  @GetMapping("/membership/register/{membershipId}")
  ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {

    FindMembershipCommand command = FindMembershipCommand.builder()
        .membershipId(membershipId).build();

    return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
  }
}
