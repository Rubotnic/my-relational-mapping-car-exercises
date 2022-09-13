package se.lexicon.myspringbootfirstlook.dao;

import se.lexicon.myspringbootfirstlook.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {

    Car save(Car car);
    Optional<Car> findById(int id);
    List<Car> findAll();
    void remove(int carId);
    Car update(Car car);
    List<Car> saveCars(List<Car> cars);

}
