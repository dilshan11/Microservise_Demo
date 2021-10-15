package lk.codelabs.rentcloud.vehicleservice.service;

import lk.codelabs.rentcloud.model.vehicle.Vehicle;

import java.util.List;


public interface VehicleService {
    Vehicle save(Vehicle customer);

    Vehicle findById(int id);

    List<Vehicle> findAll();
}
