package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Driver;
import rs.ac.singidunum.f1_2025.repo.DriverRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/driver")
@CrossOrigin
@RequiredArgsConstructor
public class DriverController {
    private final DriverRepository repository;

    @GetMapping
    public List<Driver> getDrivers(){
        return repository.findAllByDeletedAtNull();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Driver saveDriver(@RequestBody Driver model) {
        Driver driver = new Driver();
        driver.setFirstName(model.getFirstName());
        driver.setDriverNumber(model.getDriverNumber());
        driver.setNationality(model.getNationality());
        driver.setDebutYear(model.getDebutYear());
        driver.setLastName(model.getLastName());
        driver.setWorldTitles(model.getWorldTitles());
        driver.setProfileImage(model.getProfileImage());
        driver.setTeamId(model.getTeamId());
        return repository.save(driver);
    }
    @PutMapping(path = "/{id}")
    public Driver updateDriver(@PathVariable Integer id, @RequestBody Driver model) {
        Driver driver = repository.findById(id).orElseThrow();
        driver.setFirstName(model.getFirstName());
        driver.setDriverNumber(model.getDriverNumber());
        driver.setNationality(model.getNationality());
        driver.setDebutYear(model.getDebutYear());
        driver.setLastName(model.getLastName());
        driver.setWorldTitles(model.getWorldTitles());
        driver.setProfileImage(model.getProfileImage());
        driver.setTeamId(model.getTeamId());
        return repository.save(driver);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteDriver(@PathVariable Integer id, @RequestBody Driver model) {
        Driver driver = repository.findById(id).orElseThrow();
        driver.setDeletedAt(LocalDateTime.now());
        repository.save(driver);
    }
}
