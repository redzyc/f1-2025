package rs.ac.singidunum.f1_2025.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.f1_2025.entity.Team;
import rs.ac.singidunum.f1_2025.repo.TeamRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository repository;

    public List<Team> getTeams(){
        return repository.findAllByDeletedAtNull();
    }
    public Optional<Team> getTeamById( Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }


    public Team createTeam(Team model) {
        Team team = new Team();
        team.setBaseLocation(model.getBaseLocation());
        team.setTeamChef(model.getTeamChef());
        team.setChampionships(model.getChampionships());
        team.setCountry(model.getCountry());
        team.setCarName(model.getCarName());
        team.setEngineSupplier(model.getEngineSupplier());
        team.setName(model.getName());
        team.setLogoUrl(model.getLogoUrl());
        team.setFoundedYear(model.getFoundedYear());
        return repository.save(team);

    }
    public Team updateTeam( Integer id,  Team model) {
        Team team = repository.findById(id).orElseThrow();
        team.setBaseLocation(model.getBaseLocation());
        team.setTeamChef(model.getTeamChef());
        team.setChampionships(model.getChampionships());
        team.setCountry(model.getCountry());
        team.setCarName(model.getCarName());
        team.setEngineSupplier(model.getEngineSupplier());
        team.setName(model.getName());
        team.setLogoUrl(model.getLogoUrl());
        team.setFoundedYear(model.getFoundedYear());
        return repository.save(team);
    }
    public void  deleteTeam( Integer id) {
        Team team = repository.findById(id).orElseThrow();
        team.setDeletedAt(LocalDateTime.now());
        repository.save(team);
    }
}
