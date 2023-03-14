package peaksoft.services;

import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

/**
 * @author kurstan
 * @created at 14.03.2023 0:39
 */
public interface CarService {
    SimpleResponse save(CarRequest request);
    List<ResponseCarsPage> getAllCars(String brand, String model);
    ResponseCarInnerPage innerPage(Long carId);
    SimpleResponse delete(Long carId);
    List<ResponseCarsPage> searchByModelBrand(String model, String brand);
}
