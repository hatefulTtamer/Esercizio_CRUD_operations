package co.develhope.eserciziocrudoperations.repositories;

import co.develhope.eserciziocrudoperations.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
