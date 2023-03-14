package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.entity.Car;

import java.util.List;

/**
 * @author kurstan
 * @created at 14.03.2023 0:29
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select new peaksoft.dto.response.ResponseCarsPage(c.id, c.brand, c.model, c.carInfo.yearOfIssue) from Car c")
    List<ResponseCarsPage> getAllCars();

    ResponseCarInnerPage getCarById(Long carId);
    List<ResponseCarsPage> getCarByBrandAndModel(String brand, String model);
}
