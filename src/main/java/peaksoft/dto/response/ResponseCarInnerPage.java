package peaksoft.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author kurstan
 * @created at 14.03.2023 9:24
 */
public record ResponseCarInnerPage(
        Long id,
        LocalDate year_of_issue,
        String engine,
        String color,
        BigDecimal price,
        LocalDate created_at,
        String owner_phone_number
        ) {
}
