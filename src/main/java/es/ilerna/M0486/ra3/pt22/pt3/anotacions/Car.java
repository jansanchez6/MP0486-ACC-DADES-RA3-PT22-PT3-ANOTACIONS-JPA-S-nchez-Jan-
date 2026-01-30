package es.ilerna.M0486.ra3.pt22.pt3.anotacions;
import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends Vehicle {

    private Integer doors;
    private Integer seats;

    public Car() {}

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
