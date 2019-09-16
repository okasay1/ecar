package be.technocite.ecar.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

//POJO pas de méthode spéciale, pas de if, de while, else, etc.
@JsonIgnoreProperties({"originalPrice"}) // on ignore du Json vers du Java
public class Car {
    private String id;
    private String brand;
    //@JsonIgnore // Ce champ est ignoré du Java vers du Json (A vérifier)
    private double originalPrice;
    private double marketPrice;
    private String vin;
    private Date year;

    public Car(String id, String brand, double originalPrice, double marketPrice, String vin, Date year) {
        this.id = id;
        this.brand = brand;
        this.originalPrice = originalPrice;
        this.marketPrice = marketPrice;
        this.vin = vin;
        this.year = year;
    }

    // On en a besoin pour que jackson puisse avoir accès via la réflexivité java de formater les données en JSON (à voir dans POSTMAN)
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public String getVin() {
        return vin;
    }

    public Date getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", originalPrice=" + originalPrice +
                ", marketPrice=" + marketPrice +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                '}';
    }
}
