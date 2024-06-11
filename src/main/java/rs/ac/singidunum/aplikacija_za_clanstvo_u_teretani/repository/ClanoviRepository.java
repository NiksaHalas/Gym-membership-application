package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClanoviRepository extends JpaRepository<Clan, Integer> {

    List<Clan> findAllByDeletedAtIsNull();

    Optional<Clan> findByIdAndDeletedAtIsNull(Integer id);

    List<Clan> findByImeContainsAndDeletedAtIsNull(String ime);
}
