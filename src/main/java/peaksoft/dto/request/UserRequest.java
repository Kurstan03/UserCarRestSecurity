package peaksoft.dto.request;

import peaksoft.entity.enums.Role;

/**
 * @author kurstan
 * @created at 14.03.2023 1:29
 */
public record UserRequest(
        String email,
        String password,
        Role role,
        String phoneNumber
) {
}
