import com.fasterxml.jackson.databind.ObjectMapper;
import com.likipay.money.BankingApplication;
import com.likipay.money.adapter.in.web.RegisterBankingAccountInfoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = BankingApplication.class)
@AutoConfigureMockMvc
public class RegisterBankAccountControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;


//  @Test
//  void testRegisterBankAccount() throws Exception {
//    ObjectMapper mapper1 = new ObjectMapper();
//    RegisterBankingAccountInfoRequest req = new RegisterBankingAccountInfoRequest("1", "토스뱅크", "1010", true);
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/banking/account/register")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(mapper1.writeValueAsString(req))
//    ).andExpect(MockMvcResultMatchers.status().isOk());
//
//
//  }

//  @Test
//  public void testMembershipRegister() throws Exception {
//
//    RegisterMemberShipCommand command = new RegisterMemberShipCommand("name", "email", "address", true, false);
//
//    Membership membership = Membership.generateMembership(
//        new MembershipId("1"),
//        new MembershipName("name"),
//        new MembershipEmail("email"),
//        new MembershipAddress("address"),
//        new MembershipIsValid(true),
//        new MembershipIsCorp(false)
//    );
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/membership/register")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(mapper.writeValueAsString(command))
//    ).andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));
//    ;
//  }

}
