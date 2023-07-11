package com.likipay.membership;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.likipay.membership.application.port.in.RegisterMemberShipCommand;
import com.likipay.membership.domain.Membership;
import com.likipay.membership.domain.Membership.MembershipAddress;
import com.likipay.membership.domain.Membership.MembershipEmail;
import com.likipay.membership.domain.Membership.MembershipId;
import com.likipay.membership.domain.Membership.MembershipIsCorp;
import com.likipay.membership.domain.Membership.MembershipIsValid;
import com.likipay.membership.domain.Membership.MembershipName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = MembershipApplication.class)
@AutoConfigureMockMvc
public class RegisterMembershipControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @Test
  public void testMembershipRegister() throws Exception {

    RegisterMemberShipCommand command = new RegisterMemberShipCommand("name", "email", "address", true, false);

    Membership membership = Membership.generateMembership(
        new MembershipId("1"),
        new MembershipName("name"),
        new MembershipEmail("email"),
        new MembershipAddress("address"),
        new MembershipIsValid(true),
        new MembershipIsCorp(false)
    );

    mockMvc.perform(MockMvcRequestBuilders.post("/membership/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(command))
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));
    ;
  }

}
