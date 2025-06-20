package rs.ac.singidunum.f1_2025.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.f1_2025.entity.Race;
import rs.ac.singidunum.f1_2025.repo.RaceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository repository;


    public List<Race> getRaces(){
        return repository.findAllByDeletedAtNull();
    }
    public Optional<Race> getRaceById( Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Race createRace( Race model) {
        Race race = new Race();
        race.setName(model.getName());
        race.setRacePicture(model.getRacePicture());
        race.setLocation(model.getLocation());
        race.setCountry(model.getCountry());
        race.setRaceDate(model.getRaceDate());
        race.setLapLengthKm(model.getLapLengthKm());
        race.setLapCount(model.getLapCount());
        race.setTrackType(model.getTrackType());
        return repository.save(race);
    }
    public Race updateRace(Integer id,  Race model) {
        Race race = repository.findById(id).orElseThrow();
        race.setName(model.getName());
        race.setRacePicture(model.getRacePicture());
        race.setLocation(model.getLocation());
        race.setCountry(model.getCountry());
        race.setRaceDate(model.getRaceDate());
        race.setLapLengthKm(model.getLapLengthKm());
        race.setLapCount(model.getLapCount());
        race.setTrackType(model.getTrackType());
        return repository.save(race);
    }
    public void  deleteRace( Integer id) {
        Race race = repository.findById(id).orElseThrow();
        race.setDeletedAt(LocalDateTime.now());
        repository.save(race);
    }
}
