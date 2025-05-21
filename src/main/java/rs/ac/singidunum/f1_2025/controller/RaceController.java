package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Race;
import rs.ac.singidunum.f1_2025.repo.RaceRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/race")
@CrossOrigin
@RequiredArgsConstructor
public class RaceController {
    private final RaceRepository repository;

    @GetMapping
    public List<Race> getRaces(){
        return repository.findAllByDeletedAtNull();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Race saveRace(@RequestBody Race model) {
        Race race = new Race();
        race.setName(race.getName());
        race.setLocation(race.getLocation());
        race.setCountry(race.getCountry());
        race.setDate(race.getDate());
        race.setStartTime(race.getStartTime());
        race.setLapLengthKm(race.getTotalDistanceKm());
        race.setLapCount(race.getLapCount());
        race.setTotalDistanceKm(race.getTotalDistanceKm());
        race.setTrackType(race.getTrackType());
        return repository.save(race);
    }
    @PutMapping(path = "/{id}")
    public Race updateRace(@PathVariable Integer id, @RequestBody Race model) {
        Race race = repository.findById(id).orElseThrow();
        race.setName(race.getName());
        race.setLocation(race.getLocation());
        race.setCountry(race.getCountry());
        race.setDate(race.getDate());
        race.setStartTime(race.getStartTime());
        race.setLapLengthKm(race.getTotalDistanceKm());
        race.setLapCount(race.getLapCount());
        race.setTotalDistanceKm(race.getTotalDistanceKm());
        race.setTrackType(race.getTrackType());
        return repository.save(race);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteRace(@PathVariable Integer id, @RequestBody Race model) {
        Race race = repository.findById(id).orElseThrow();
        race.setDeletedAt(LocalDateTime.now());
        repository.save(race);
    }
}
