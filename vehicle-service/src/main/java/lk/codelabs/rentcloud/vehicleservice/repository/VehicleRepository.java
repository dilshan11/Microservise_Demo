package lk.codelabs.rentcloud.vehicleservice.repository;

import lk.codelabs.rentcloud.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
