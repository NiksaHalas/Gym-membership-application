package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Plan;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findAllByDeletedAtIsNull();

    Optional<Plan> findByIdAndDeletedAtIsNull(Integer id);



}
