package se.lexicon.myspringbootfirstlook.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

// ----MANY-TO-ONE-----

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    @Column(nullable = false, length = 100)
    private String regNumber;
    @Column(nullable = false, length = 100)
    private String brand;
    @Column(nullable = false, length = 100)
    private String model;
    @CreationTimestamp
    @Column(name = "register_date", columnDefinition = "TIMESTAMP")
    private LocalDate regDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    private AppUser owner;

    public Car() {}

    public Car(int carId, String regNumber, String brand, String model, LocalDate regDate, AppUser owner) {
        this.carId = carId;
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
        this.owner = owner;
    }


    public Car(String brand){
        this.brand = brand;
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && Objects.equals(regNumber, car.regNumber) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(regDate, car.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getRegNumber(), getBrand(), getModel(), getRegDate());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                ", owner=" + owner +
                '}';
    }
}