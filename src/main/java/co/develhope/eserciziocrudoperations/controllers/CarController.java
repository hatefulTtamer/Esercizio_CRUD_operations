package co.develhope.eserciziocrudoperations.controllers;

import co.develhope.eserciziocrudoperations.entities.Car;
import co.develhope.eserciziocrudoperations.repositories.CarRepo;
import co.develhope.eserciziocrudoperations.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Car getCar(@PathVariable long id) {
        return carService.get(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car) {
        car.setId(id);
        return carService.create(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.delete(id);
    }

    @DeleteMapping
    public void deleteAllCars() {
        carService.deleteAll();
    }

}
