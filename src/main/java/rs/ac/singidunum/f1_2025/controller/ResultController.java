package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Result;
import rs.ac.singidunum.f1_2025.repo.ResultRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/result")
@CrossOrigin
@RequiredArgsConstructor
public class ResultController {
    private final ResultRepository repository;

    @GetMapping
    public List<Result> getResults(){
        return repository.findAllByDeletedAtNull();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Result saveResult(@RequestBody Result model) {
        Result result = new Result();
        result.setRaceId(result.getRaceId());
        result.setPosition(result.getPosition());
        result.setDriverId(result.getDriverId());
        result.setStatus(result.getStatus());
        result.setLapsCompleted(result.getLapsCompleted());
        result.setPitStops(result.getPitStops());
        result.setTimeGap(result.getTimeGap());
        result.setStatus(result.getStatus());
        return repository.save(result);
    }
    @PutMapping(path = "/{id}")
    public Result updateResult(@PathVariable Integer id, @RequestBody Result model) {
        Result result = repository.findById(id).orElseThrow();
        result.setRaceId(result.getRaceId());
        result.setPosition(result.getPosition());
        result.setDriverId(result.getDriverId());
        result.setStatus(result.getStatus());
        result.setLapsCompleted(result.getLapsCompleted());
        result.setPitStops(result.getPitStops());
        result.setTimeGap(result.getTimeGap());
        result.setStatus(result.getStatus());
        return repository.save(result);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteResult(@PathVariable Integer id, @RequestBody Result model) {
        Result result = repository.findById(id).orElseThrow();
        result.setDeletedAt(LocalDateTime.now());
        repository.save(result);
    }
}
