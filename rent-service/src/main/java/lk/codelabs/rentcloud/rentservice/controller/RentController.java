package lk.codelabs.rentcloud.rentservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lk.codelabs.rentcloud.model.rent.Rent;
import lk.codelabs.rentcloud.rentservice.model.ResponFallback;
import lk.codelabs.rentcloud.rentservice.model.Response;
import lk.codelabs.rentcloud.rentservice.model.SimpleResponse;
import lk.codelabs.rentcloud.rentservice.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/rents")
public class RentController {


    private static final String ORDER_SERVICE = "orderService";
    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/nobreaker/{id}")
    public Response getRentNoBreaker(@PathVariable int id) {

        return rentService.findDetailResponse(id);
    }

    @GetMapping(value = "/cbreaker/{id}")
    @CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "orderFallback")
    public Response getRentWithCbreaker(@PathVariable int id) {

        return rentService.findDetailResponse(id);
    }

    public ResponFallback orderFallback(int id,Exception e){
        System.out.println("getRent is fialed...Cicuite breker activated");
        ResponFallback responFallback=new ResponFallback("getRent is fialed...Cicuite breker activated ");

        return responFallback;
    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }
}
