package peaksoft.dto.response;

import java.time.LocalDate;

/**
 * @author kurstan
 * @created at 14.03.2023 0:46
 */
public record ResponseCarsPage(
        Long id,
        String brand,
        String model,
        LocalDate yearOfIssue
) {
}
