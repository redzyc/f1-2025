package rs.ac.singidunum.f1_2025.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Result;
import rs.ac.singidunum.f1_2025.entity.Team;
import rs.ac.singidunum.f1_2025.repo.ResultRepository;
import rs.ac.singidunum.f1_2025.repo.TeamRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository repository;

    public List<Result> getResults(){
        return repository.findAllByDeletedAtNull();
    }
    public Optional<Result> getResultById( Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Result createResult( Result model) {
        Result result = new Result();
        result.setRaceId(model.getRaceId());
        result.setPosition(model.getPosition());
        result.setDriverId(model.getDriverId());
        result.setStatus(model.getStatus());
        result.setLapsCompleted(model.getLapsCompleted());
        result.setPitStops(model.getPitStops());
        result.setTimeGap(model.getTimeGap());
        result.setStatus(model.getStatus());
        return repository.save(result);
    }
    public Result updateResult( Integer id,  Result model) {
        Result result = repository.findById(id).orElseThrow();
        result.setRaceId(model.getRaceId());
        result.setPosition(model.getPosition());
        result.setDriverId(model.getDriverId());
        result.setStatus(model.getStatus());
        result.setLapsCompleted(model.getLapsCompleted());
        result.setPitStops(model.getPitStops());
        result.setTimeGap(model.getTimeGap());
        result.setStatus(model.getStatus());
        return repository.save(result);
    }
    public void  deleteResult( Integer id) {
        Result result = repository.findById(id).orElseThrow();
        result.setDeletedAt(LocalDateTime.now());
        repository.save(result);
    }
}
