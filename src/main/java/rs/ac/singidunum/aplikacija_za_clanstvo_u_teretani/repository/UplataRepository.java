package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Uplata;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UplataRepository extends JpaRepository<Uplata, Integer> {

    List<Uplata> findAllByDatumUplateBetween(LocalDateTime start, LocalDateTime end);

    Optional<Uplata> findByIdAndDatumUplateAfter(Integer id, LocalDateTime date);

    List<Uplata> findByClanIdAndDatumUplateAfter(Integer clanId, LocalDateTime date);

    List<Uplata> findByIznosGreaterThan(Double iznos);
}
