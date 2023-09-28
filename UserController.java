import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserService userService;

   @PutMapping("/{userId}/update-profile")
   public User updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileRequest userProfileRequest) {
       
       return userService.updateUserProfile(userId, userProfileRequest);
   }

   @PutMapping("/{userId}/update-password")
   public User updateUserPassword(@PathVariable Long userId, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
       
       return userService.updateUserPassword(userId, updatePasswordRequest);
   }

   @PutMapping("/{userId}/update-delivery-addresses")
   public User updateUserDeliveryAddresses(@PathVariable Long userId, @RequestBody List<DeliveryAddress> deliveryAddresses) {
       
       return userService.updateUserDeliveryAddresses(userId, deliveryAddresses);
   }
}
