package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author kurstan
 * @created at 13.03.2023 20:02
 */
@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_id_gen",
            sequenceName = "car_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_id_gen"
    )
    private Long id;
    private String brand;
    private String model;
    @OneToOne
    private CarInfo carInfo;
    private LocalDate createdAt;
}
