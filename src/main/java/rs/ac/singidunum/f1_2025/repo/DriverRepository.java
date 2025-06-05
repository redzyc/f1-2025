package rs.ac.singidunum.f1_2025.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.f1_2025.entity.Driver;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> findAllByDeletedAtNull();
    Optional<Driver> findByIdAndDeletedAtIsNull(Integer id);
    List<Driver> findByTeamIdAndDeletedAtIsNull(Integer teamId);

}