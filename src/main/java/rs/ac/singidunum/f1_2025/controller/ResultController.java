package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Result;
import rs.ac.singidunum.f1_2025.service.ResultService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/result")
@CrossOrigin
@RequiredArgsConstructor
public class ResultController {
    private final ResultService service;

    @GetMapping
    public List<Result> getResults(){
        return service.getResults();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Integer id){
        return ResponseEntity.of(service.getResultById(id));
    }

    @PostMapping
    public Result saveResult(@RequestBody Result model) {
        return service.createResult(model);
    }
    @PutMapping(path = "/{id}")
    public Result updateResult(@PathVariable Integer id, @RequestBody Result model) {
        return service.updateResult(id,model);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteResult(@PathVariable Integer id) {
        service.deleteResult(id);
    }
}
