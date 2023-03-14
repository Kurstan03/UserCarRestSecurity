package peaksoft.dto.request;

import peaksoft.entity.CarInfo;

/**
 * @author kurstan
 * @created at 14.03.2023 9:21
 */
public record CarRequest(
        String brand,
        String model,
        CarInfo carInfo
) {
}
