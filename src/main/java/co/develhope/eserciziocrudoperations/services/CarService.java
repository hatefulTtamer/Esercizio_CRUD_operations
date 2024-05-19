package co.develhope.eserciziocrudoperations.services;

import co.develhope.eserciziocrudoperations.entities.Car;
import co.develhope.eserciziocrudoperations.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Car get(long id) {
        if (!carRepo.existsById(id)) {
            return carRepo.saveAndFlush(new Car());
        } else {
            return carRepo.getReferenceById(id);
        }
    }

    public void delete (long id) {
        carRepo.delete(carRepo.getReferenceById(id));
    }

    public void deleteAll() {
        carRepo.deleteAll();
    }
}
