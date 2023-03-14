package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author kurstan
 * @created at 13.03.2023 20:16
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select new peaksoft.dto.response.UserResponse(u.id, u.email, u.role, u.phoneNumber) from User u")
    List<UserResponse> getAllUsers();

    @Query("select new peaksoft.dto.response.UserResponseProfile(u.email, u.phoneNumber) from User u")
    Optional<UserResponseProfile> profile();

    @Query("select new peaksoft.dto.response.ResponseCarsPage(c.id, c.brand, c.model, c.carInfo.yearOfIssue) from User u join u.cars c where u.id = ?1")
    List<ResponseCarsPage> getAllCarByUserId(Long userId);

    UserResponse getUserById(Long userId);

    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);
}
