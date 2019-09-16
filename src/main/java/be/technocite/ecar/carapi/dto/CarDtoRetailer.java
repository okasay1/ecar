package be.technocite.ecar.carapi.dto;

import java.util.Date;

// Pendant Json de la classe, un vrai POJO sans jpa.
public class CarDtoRetailer {
    private String id;
    private String brand;
    private double originalPrice;
    private double marketPrice;
    private String vin;
    private Date year;

    public CarDtoRetailer(String id, String brand, double originalPrice, double marketPrice, String vin, Date year) {
        this.id = id;
        this.brand = brand;
        this.originalPrice = originalPrice;
        this.marketPrice = marketPrice;
        this.vin = vin;
        this.year = year;
    }
}
