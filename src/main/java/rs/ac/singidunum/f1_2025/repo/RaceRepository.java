package rs.ac.singidunum.f1_2025.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.f1_2025.entity.Race;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race,Integer> {
    List<Race> findAllByDeletedAtNull();
}
