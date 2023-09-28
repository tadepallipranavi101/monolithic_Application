import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   public User updateUserProfile(Long userId, UserProfileRequest userProfileRequest) {
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

       user.setFullName(userProfileRequest.getFullName());

       // Save the updated user profile
       return userRepository.save(user);
   }

   public User updateUserPassword(Long userId, UpdatePasswordRequest updatePasswordRequest) {
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

      
       return userRepository.save(user);
   }

   public User updateUserDeliveryAddresses(Long userId, List<DeliveryAddress> deliveryAddresses) {
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

       // Update user's delivery addresses
       user.setDeliveryAddresses(deliveryAddresses);

       // Save the updated user with delivery addresses
       return userRepository.save(user);
   }
}
