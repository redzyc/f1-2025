package rs.ac.singidunum.f1_2025.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.f1_2025.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    List<Team> findAllByDeletedAtNull();
}
