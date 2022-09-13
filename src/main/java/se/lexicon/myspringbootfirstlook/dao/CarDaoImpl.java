package se.lexicon.myspringbootfirstlook.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myspringbootfirstlook.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDaoImpl implements CarDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public Car save(Car car) {
        if(car == null) throw new IllegalArgumentException("Car not to be null");
        if(car.getCarId() <= 0){
            entityManager.persist(car);
            return car;
        }else {
            entityManager.merge(car);
        }
        return car;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Car> findById(int id) {
        Car car = entityManager.find(Car.class, id);
        return Optional.ofNullable(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void remove(int carId) {
        findById(carId).ifPresent(entityManager::remove);

    }

    @Transactional
    @Override
    public Car update(Car car) {
        return null;
    }

    @Transactional
    @Override
    public List<Car> saveCars(List<Car> cars) {
        return null;
    }
}