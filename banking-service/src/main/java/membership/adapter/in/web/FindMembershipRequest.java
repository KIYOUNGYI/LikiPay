package membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMembershipRequest {

  private String name;
  private String address;
  private String email;
  private boolean isCorp;

}
