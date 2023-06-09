package peaksoft.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.services.UserService;

import java.util.List;

/**
 * @author kurstan
 * @created at 13.03.2023 20:01
 */
@RestController
@RequestMapping("/api/users")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'USER')")
    List<UserResponse> getAll(){
        return userService.getAllUsers();
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'USER')")
    SimpleResponse save(@RequestBody UserRequest request){
        return userService.saveUser(request);
    }
    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'USER')")
    UserResponseProfile profile(@PathVariable Long userId){
        return userService.profile(userId);
    }
    @PutMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'USER')")
    UserResponse update(@PathVariable Long userId, @RequestBody UserRequest request){
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDOR', 'USER')")
    SimpleResponse delete(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
