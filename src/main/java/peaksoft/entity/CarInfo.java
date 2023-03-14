package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author kurstan
 * @created at 13.03.2023 20:03
 */
@Entity
@Table(name = "car_infos")
@Getter
@Setter
@NoArgsConstructor
public class CarInfo {
    @Id
    @SequenceGenerator(
            name = "car_info_gen",
            sequenceName = "car_info_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_info_gen"
    )
    private Long id;
    private LocalDate yearOfIssue;
    private String engine;
    private String color;
    private BigDecimal price;
}
