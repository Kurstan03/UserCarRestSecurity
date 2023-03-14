package peaksoft.api;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.services.CarService;

import java.util.List;

/**
 * @author kurstan
 * @created at 14.03.2023 9:44
 */
@RestController
@RequestMapping("/api/cars")
public class CarApi {
    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    List<ResponseCarsPage> getAll(@RequestParam(name = "model", required = false) String model,
                                  @RequestParam(name = "brand", required = false) String brand){
        return carService.getAllCars();
    }
    @PostMapping
    SimpleResponse save(@RequestBody CarRequest request){
        return carService.save(request);
    }
    @GetMapping("/{carId}")
    ResponseCarInnerPage innerPage(@PathVariable Long carId){
        return carService.innerPage(carId);
    }
    @DeleteMapping("/{carId}")
    SimpleResponse delete(@PathVariable Long carId){
        return carService.delete(carId);
    }
}
