package be.technocite.ecar.car.dao.impl;

import be.technocite.ecar.car.dao.CarDao;
import be.technocite.ecar.car.model.Car;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

//@Component // pour dire que c'est un bean
@Repository // Donc un bean qui va gérer la persistance de données. Classe qui a la responsabilité de persister les données
// quelle que soit sa forme
public class CarDaoImpl implements CarDao {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private List<Car> cars = newArrayList();

    @Override
    public int count() {
        return cars.size();
    }

    @Override
    public Car findById(String id) {
            return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null); // si on ne trouve pas
        // pour gérer le null
    }

    @Override
    public Car save(Car car) {
        int carIndex = cars.indexOf(car);

        if(carIndex == -1){ // if(carIndex == -1)
            cars.add(car);
            return cars.get(cars.size() - 1);
        }else{
            cars.set(carIndex, car);
            return cars.get(carIndex);
        }

    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public boolean delete(String id) {

        Car carPersisted = findById(id);

        if(carPersisted != null)
            return cars.remove(carPersisted);
        else return false;
    }

    @PostConstruct
    private void onPostConstruct(){
        try {
            cars.add(new Car(UUID.randomUUID().toString(),
                    "BMW",
                    10,
                    25000,
                    "lsnidcf543580",
                    simpleDateFormat.parse("2011-09-19")));

            cars.add(new Car(UUID.randomUUID().toString(),
                    "MERCEDES",
                    10,
                    25000,
                    "djzeqefjlq5666",
                    simpleDateFormat.parse("2012-08-20")));

            cars.add(new Car(UUID.randomUUID().toString(),
                    "LADA",
                    10,
                    25000,
                    "frkfmzfem9896565",
                    simpleDateFormat.parse("1968-05-10")));

            cars.add(new Car(UUID.randomUUID().toString(),
                    "AUDI",
                    10,
                    25000,
                    "ekùskrgùrqlg2335",
                    simpleDateFormat.parse("2011-09-19")));

            cars.add(new Car(UUID.randomUUID().toString(),
                    "VW",
                    10,
                    25000,
                    "zfzefmle2688",
                    simpleDateFormat.parse("2011-09-19")));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
