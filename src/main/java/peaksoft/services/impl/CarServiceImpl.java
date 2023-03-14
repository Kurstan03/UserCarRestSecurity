package peaksoft.services.impl;

import org.springframework.stereotype.Service;
import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Car;
import peaksoft.repositories.CarRepository;
import peaksoft.services.CarService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author kurstan
 * @created at 14.03.2023 0:40
 */
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public SimpleResponse save(CarRequest request) {
        Car car = new Car();
        car.setBrand(request.brand());
        car.setModel(request.model());
        car.setCarInfo(request.carInfo());
        car.setCreatedAt(LocalDate.now());
        carRepository.save(car);
        return new SimpleResponse(
                "Saved!",
                "Car - " + car.getModel() + " is saved!"
        );
    }

    @Override
    public List<ResponseCarsPage> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public ResponseCarInnerPage innerPage(Long carId) {
        return carRepository.getCarById(carId);
    }

    @Override
    public SimpleResponse delete(Long carId) {
        if (!carRepository.existsById(carId)) {
            throw new NoSuchElementException("Not found!");
        }
        carRepository.deleteById(carId);
        return new SimpleResponse(
                "Delete",
                "Car with id - " + carId + " is deleted!"
        );
    }

    @Override
    public List<ResponseCarsPage> searchByModelBrand(String model, String brand) {
        return carRepository.getCarByBrandAndModel(brand, model);
    }
}
