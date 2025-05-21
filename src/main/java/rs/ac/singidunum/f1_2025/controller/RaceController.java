package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Race;
import rs.ac.singidunum.f1_2025.service.RaceService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/races")
@CrossOrigin
@RequiredArgsConstructor
public class RaceController {
    private final RaceService service;

    @GetMapping
    public List<Race> getRaces(){
        return service.getRaces();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Integer id){
        return ResponseEntity.of(service.getRaceById(id));
    }

    @PostMapping
    public Race saveRace(@RequestBody Race model) {
        return service.createRace(model);
    }
    @PutMapping(path = "/{id}")
    public Race updateRace(@PathVariable Integer id, @RequestBody Race model) {
        return service.updateRace(id,model);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteRace(@PathVariable Integer id) {
        service.deleteRace(id);
    }
}
