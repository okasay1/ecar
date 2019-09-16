package be.technocite.ecar.car.dao;

import be.technocite.ecar.car.model.Car;

import java.util.List;

//Pour le Pattern DAO, très simple, ce compose d'une ou deux classes
public interface CarDao {

    Car findById(String id);

    // Permet de sauvegarder et de modifier une voiture. Renvoie l'objet sauvegardé (Convention dans les ORM)
    Car save(Car car);

    boolean delete(String id);

    int count();

    List<Car> findAll();
}
