package rs.ac.singidunum.f1_2025.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.f1_2025.entity.Team;
import rs.ac.singidunum.f1_2025.repo.TeamRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/team")
@CrossOrigin
@RequiredArgsConstructor
public class TeamController {
    private final TeamRepository repository;

    @GetMapping
    public List<Team> getTeams(){
        return repository.findAllByDeletedAtNull();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team model) {
        Team team = new Team();
        team.setBaseLocation(team.getBaseLocation());
        team.setTeamChef(team.getTeamChef());
        team.setChampionships(team.getChampionships());
        team.setCountry(team.getCountry());
        team.setCarName(team.getCarName());
        team.setEngineSupplier(team.getEngineSupplier());
        team.setName(team.getName());
        team.setLogoUrl(team.getLogoUrl());
        team.setFoundedYear(model.getFoundedYear());
        return repository.save(team);

    }
    @PutMapping(path = "/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team model) {
        Team team = repository.findById(id).orElseThrow();
        team.setBaseLocation(team.getBaseLocation());
        team.setTeamChef(team.getTeamChef());
        team.setChampionships(team.getChampionships());
        team.setCountry(team.getCountry());
        team.setCarName(team.getCarName());
        team.setEngineSupplier(team.getEngineSupplier());
        team.setName(team.getName());
        team.setLogoUrl(team.getLogoUrl());
        team.setFoundedYear(model.getFoundedYear());
        return repository.save(team);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteTeam(@PathVariable Integer id, @RequestBody Team model) {
        Team team = repository.findById(id).orElseThrow();
        team.setDeletedAt(LocalDateTime.now());
        repository.save(team);
    }
}
