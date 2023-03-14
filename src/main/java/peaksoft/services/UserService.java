package peaksoft.services;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;

import java.util.List;

/**
 * @author kurstan
 * @created at 13.03.2023 20:19
 */
public interface UserService {
    List<UserResponse> getAllUsers();
    SimpleResponse saveUser(UserRequest request);
    UserResponseProfile profile(Long userId);
    UserResponse updateUser(Long userId, UserRequest request);
    SimpleResponse deleteUser(Long userId);

}
