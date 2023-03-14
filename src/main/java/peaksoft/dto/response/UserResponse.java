package peaksoft.dto.response;

import peaksoft.entity.enums.Role;

/**
 * @author kurstan
 * @created at 14.03.2023 1:23
 */
public record UserResponse(
       Long id,
       String email,
       Role role,
       String phoneNumber
) {
}
