package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Driver;
import rs.ac.singidunum.f1_2025.service.DriverService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/drivers")
@CrossOrigin
@RequiredArgsConstructor
public class DriverController {
    private final DriverService service;

    @GetMapping
    public List<Driver> getAllActiveDrivers(@RequestParam(required = false) Integer teamId) {
        return service.getAllActiveDrivers(teamId);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Integer id){
        return ResponseEntity.of(service.getDriverById(id));
    }

    @PostMapping
    public Driver saveDriver(@RequestBody Driver model) {
        return service.createDriver(model);
    }
    @PutMapping(path = "/{id}")
    public Driver updateDriver(@PathVariable Integer id, @RequestBody Driver model) {
        return service.updateDriver(id,model);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteDriver(@PathVariable Integer id) {
        service.deleteDriver(id);
    }
}
