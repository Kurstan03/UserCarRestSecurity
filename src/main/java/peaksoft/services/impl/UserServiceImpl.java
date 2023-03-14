package peaksoft.services.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.entity.User;
import peaksoft.entity.enums.Role;
import peaksoft.repositories.UserRepository;
import peaksoft.services.UserService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author kurstan
 * @created at 13.03.2023 20:20
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostConstruct
    public void init(){
        if (!userRepository.existsByEmail("admin@gmail.com")) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setPassword("admin123");
            user.setPhoneNumber("0220113355");
            user.setRole(Role.ADMIN);
            userRepository.save(user);
        }
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public SimpleResponse saveUser(UserRequest request) {
        User user = new User();
        user.setEmail(request.email());
        user.setRole(request.role());
        user.setPhoneNumber(request.phoneNumber());
        user.setPassword(request.password());
        userRepository.save(user);
        return new SimpleResponse(
                "Save",
                "User - " + user.getEmail() + " is not saved!"
        );
    }

    @Override
    public UserResponseProfile profile(Long userId) {
        UserResponseProfile userResponseProfile = userRepository.profile()
                .orElseThrow(() -> new NoSuchElementException(
                        "User with id - " + userId + " is not found!"));
        userResponseProfile.setResponseCarsPages(userRepository.getAllCarByUserId(userId));
        return userResponseProfile;
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NoSuchElementException("Not found!")
        );
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(request.role());
        user.setPhoneNumber(request.phoneNumber());

        return userRepository.getUserById(userId);
    }

    @Override
    public SimpleResponse deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User with id - " + userId + " doesn't exists!");
        }
        userRepository.deleteById(userId);
        return new SimpleResponse(
                "Delete",
                "User with id - " + userId + " is deleted!"
        );
    }
}
