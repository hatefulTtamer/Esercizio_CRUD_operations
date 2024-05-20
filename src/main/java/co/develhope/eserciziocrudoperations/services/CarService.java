package co.develhope.eserciziocrudoperations.services;

import co.develhope.eserciziocrudoperations.entities.Car;
import co.develhope.eserciziocrudoperations.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public Car create(Car car) {
        return carRepo.saveAndFlush(car);
    }

    public List<Car> getList() {
        return carRepo.findAll();
    }

    public Optional<Car> get(long id) {
        if (!carRepo.existsById(id)) {
            return Optional.empty();
        } else {
            return carRepo.findById(id);
        }
    }

    public Optional<Car> update(long id, String string) {
        if (!carRepo.existsById(id)) {
            return Optional.empty();
        } else {
            Optional<Car> optionalCar = carRepo.findById(id);
            Car car = optionalCar.get();
            car.setType(string);
            return Optional.of(car);
        }
    }

    public void delete(long id) {
        carRepo.deleteById(id);
    }

    public void deleteAll() {
        carRepo.deleteAll();
    }
}
