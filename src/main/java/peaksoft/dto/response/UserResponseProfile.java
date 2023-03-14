package peaksoft.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author kurstan
 * @created at 14.03.2023 0:42
 */
@Getter
@Setter
@NoArgsConstructor
public class UserResponseProfile {
   private Long id;
   private String email;
   private String phoneNumber;
   private List<ResponseCarsPage> responseCarsPages;

   public UserResponseProfile(String email, String phoneNumber) {
      this.email = email;
      this.phoneNumber = phoneNumber;
   }
}
