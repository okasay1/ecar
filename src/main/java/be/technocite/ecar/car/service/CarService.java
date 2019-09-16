package be.technocite.ecar.car.service;

import be.technocite.ecar.car.model.Car;
import be.technocite.ecar.carapi.dto.CarDtoBuyer;
import be.technocite.ecar.carapi.dto.CarDtoRetailer;
import org.springframework.stereotype.Service;

@Service // Précise le type de bean, un service est une classe à tout faire(convertir, manipuler des choses en dehors
// des responsabilités de la classe
public class CarService {

    private CarDtoBuyer converToBuyerDto(Car car) {
        return new CarDtoBuyer(
                car.getId(),
        car.getBrand(),
        car.getMarketPrice(),
        car.getVin(),
        car.getYear()
        );
    }

    private CarDtoRetailer converToRetailerDto(Car car) {
        return new CarDtoRetailer(
                car.getId(),
                car.getBrand(),
                car.getOriginalPrice(),
                car.getMarketPrice(),
                car.getVin(),
                car.getYear()
        );

    }
}
