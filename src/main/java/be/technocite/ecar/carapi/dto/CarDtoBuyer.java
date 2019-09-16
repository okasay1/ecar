package be.technocite.ecar.carapi.dto;

import java.util.Date;

public class CarDtoBuyer {
    private String id;
    private String brand;
    //private double originalPrice; A cacher au buyer
    private double marketPrice;
    private String vin;
    private Date year;

    public CarDtoBuyer(String id, String brand, double marketPrice, String vin, Date year) {
        this.id = id;
        this.brand = brand;
        this.marketPrice = marketPrice;
        this.vin = vin;
        this.year = year;
    }
}
