package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Team;
import rs.ac.singidunum.f1_2025.service.TeamService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
@CrossOrigin
@RequiredArgsConstructor
public class TeamController {
    private final TeamService service;

    @GetMapping
    public List<Team> getTeams(){
        return service.getTeams();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id){
        return ResponseEntity.of(service.getTeamById(id));
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team model) {
        return service.createTeam(model);
    }
    @PutMapping(path = "/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team model) {
        return service.updateTeam(id,model);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteTeam(@PathVariable Integer id) {
        service.deleteTeam(id);
    }
}
