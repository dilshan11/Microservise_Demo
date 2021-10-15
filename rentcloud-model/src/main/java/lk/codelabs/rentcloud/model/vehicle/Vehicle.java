package lk.codelabs.rentcloud.model.vehicle;

import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String make;
    String model;
    String type;
    int year;
    int odometerValueOnRegister;
    String color;


}
