package rs.ac.singidunum.f1_2025.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.f1_2025.entity.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
    List<Result> findAllByDeletedAtNull();
}
