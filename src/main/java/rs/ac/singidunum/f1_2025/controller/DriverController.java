package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Driver;
import rs.ac.singidunum.f1_2025.repo.DriverRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/driver")
@CrossOrigin
@RequiredArgsConstructor
public class DriverController {
    private final DriverRepository repository;

    @GetMapping
    public List<Driver> getDrivers(){
        return repository.findAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Driver saveDriver(@RequestBody Driver model) {
        Driver driver = new Driver();
        driver.setFirst_name(model.getFirst_name());
        driver.setDriver_number(model.getDriver_number());
        driver.setNationality(model.getNationality());
        driver.setDebut_year(model.getDebut_year());
        driver.setLast_name(model.getLast_name());
        driver.setWorld_titles(model.getWorld_titles());
        driver.setProfile_image(model.getProfile_image());
        driver.setTeam_id(model.getTeam_id());
        return repository.save(driver);
    }
    @PutMapping(path = "/{id}")
    public Driver updateDriver(@PathVariable Integer id, @RequestBody Driver model) {
        Driver driver = repository.findById(id).orElseThrow();
        driver.setFirst_name(model.getFirst_name());
        driver.setDriver_number(model.getDriver_number());
        driver.setNationality(model.getNationality());
        driver.setDebut_year(model.getDebut_year());
        driver.setLast_name(model.getLast_name());
        driver.setWorld_titles(model.getWorld_titles());
        driver.setProfile_image(model.getProfile_image());
        driver.setTeam_id(model.getTeam_id());
        return repository.save(driver);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteDriver(@PathVariable Integer id, @RequestBody Driver model) {
        Driver driver = repository.findById(id).orElseThrow();
        repository.save(driver);
    }
}
