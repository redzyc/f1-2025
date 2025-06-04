package rs.ac.singidunum.f1_2025.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.f1_2025.entity.Driver;
import rs.ac.singidunum.f1_2025.repo.DriverRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repository;

    public List<Driver> getDrivers(){
        return repository.findAllByDeletedAtNull();
    }
    public Optional<Driver> getDriverById( Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }
    public List<Driver> getAllDrivers( Integer teamId) {
        if (teamId != null) {
            return repository.findByTeamId(teamId);
        }
        return repository.findAll();
    }

    public Driver createDriver( Driver model) {
        Driver driver = new Driver();
        driver.setFirstName(model.getFirstName());
        driver.setDriverNumber(model.getDriverNumber());
        driver.setNationality(model.getNationality());
        driver.setDateOfBirth(model.getDateOfBirth());
        driver.setDebutYear(model.getDebutYear());
        driver.setLastName(model.getLastName());
        driver.setWorldTitles(model.getWorldTitles());
        driver.setProfileImage(model.getProfileImage());
        driver.setTeam(model.getTeam());
        return repository.save(driver);
    }
    public Driver updateDriver( Integer id,  Driver model) {
        Driver driver = repository.findById(id).orElseThrow();
        driver.setFirstName(model.getFirstName());
        driver.setDriverNumber(model.getDriverNumber());
        driver.setDateOfBirth(model.getDateOfBirth());
        driver.setNationality(model.getNationality());
        driver.setDebutYear(model.getDebutYear());
        driver.setLastName(model.getLastName());
        driver.setWorldTitles(model.getWorldTitles());
        driver.setProfileImage(model.getProfileImage());
        driver.setTeam(model.getTeam());
        return repository.save(driver);
    }
    public void  deleteDriver(Integer id) {
        Driver driver = repository.findById(id).orElseThrow();
        driver.setDeletedAt(LocalDateTime.now());
        repository.save(driver);
    }
}
