package co.develhope.eserciziocrudoperations.controllers;

import co.develhope.eserciziocrudoperations.entities.Car;
import co.develhope.eserciziocrudoperations.repositories.CarRepo;
import co.develhope.eserciziocrudoperations.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private CarRepo carRepo;

    @PostMapping
    public Car postCar(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getList();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id) {
        return carService.get(id);
    }

    @PutMapping("/{id}")
    public Optional<Car> updateCar(@PathVariable long id, @RequestParam String string) {
        return carService.update(id, string);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        if (!carRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            carService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public void deleteAllCars() {
        carService.deleteAll();
    }

}
