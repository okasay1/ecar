package be.technocite.ecar.carapi;

import be.technocite.ecar.car.dao.CarDao;
import be.technocite.ecar.car.model.Car;
import be.technocite.ecar.carapi.dto.CarDtoBuyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.UUID;

//@Controller // Controller Classe servant à gérer les requêtes http sur les URL en général
// comme un Servlet(spécifique à Java) Tout comme ...Context c'est général et IoCContainer est spécifique à java
//@Controller fait aussi office de déclaration de Bean @Component
@RestController // @Controller et ResponseBody (Donc déclare la classe aussi comme un bean)
public class CarController {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired // Spring déconseille injection par propriété
    private CarDao carDao;

    //Handler du Controller voir schéma 15 de SringWeb MVC
    // @RequestMapping(method = RequestMethod.GET, produces = "application/json") // Que getHelloWorld soit mappé à une http request ici la racine " "
    // @ResponseBody // Demande à Spring de sérialiser le type de retour de cette méthode avec Jackson
    // @ResponseBody // Le corps de la réponse c'est la voiture car il y a des headers, des footers !

    @GetMapping(value = "{id}") // raccourci pour dire que c'est une méthode GET avec une variable qu'on passe
    public ResponseEntity<CarDtoBuyer> getCar(@PathVariable String id) {
        Car car = carDao.findById(id);
        if (car != null)
            return ResponseEntity.ok().body(car);
        else
            return ResponseEntity.noContent().build();

    }

    // Ici on fait un webservice pas un site web mais en utilisant le Spring MVC!! On renvoie des données et pas une vue
    // On fait un POST via la méthode addCar. Il faut le faire via POSTMAN dans l'onglet body, mettre Post et y taper ce
    // que l'on envoie puis send et on peut check le status sur le serveur
    //@RequestMapping(method = RequestMethod.POST)

    @GetMapping
    public List<Car> getAllCars() {
        return carDao.findAll();
    }

    //Avec cdes réponses
    @PostMapping
    public ResponseEntity<CarDtoBuyer> addCar(@RequestBody Car car) {
        int preCount = carDao.count();
        Car carAdded = carDao.save(car);

        if (preCount == carDao.count() - 1) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(carAdded.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CarDtoBuyer> deleteCar(@PathVariable String id) {
       return null;
    }

    @PutMapping
    public ResponseEntity<CarDtoBuyer> upDateCar(@RequestBody Car car) {
        if(carDao.findById(car.getId()) != null){
            carDao.save(car);
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
