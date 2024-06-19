package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Uplata;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.UplataModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository.UplataRepository;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository.ClanoviRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UplataService {

    private final UplataRepository uplataRepository;
    private final ClanoviRepository clanoviRepository;
    private static final Logger logger = LoggerFactory.getLogger(UplataService.class);

    public List<Uplata> getAllUplate() {
        return uplataRepository.findAll();
    }

    public Optional<Uplata> getUplataById(Integer id) {
        return uplataRepository.findById(id);
    }

    public List<Uplata> getUplateByClanId(Integer clanId) {
        return uplataRepository.findByClanIdAndDatumUplateAfter(clanId, LocalDateTime.MIN);
    }

    public List<Uplata> getUplateByIznosGreaterThan(Double iznos) {
        return uplataRepository.findByIznosGreaterThan(iznos);
    }

    public List<Uplata> getUplateBetweenDates(LocalDateTime start, LocalDateTime end) {
        return uplataRepository.findAllByDatumUplateBetween(start, end);
    }

    public Uplata createUplata(UplataModel model) {

        Optional<Clan> clanOpt = clanoviRepository.findByIdAndDeletedAtIsNull(model.getClanId());

        Clan clan = clanOpt.get();
        Uplata uplata = new Uplata();
        uplata.setClan(clan);
        uplata.setIznos(model.getIznos());
        uplata.setDatumUplate(model.getDatumUplate());

        return uplataRepository.save(uplata);
    }


    public Uplata updateUplata(Integer id, UplataModel model) {
        Uplata uplata = uplataRepository.findById(id).orElseThrow();
        Clan clan = clanoviRepository.findByIdAndDeletedAtIsNull(model.getClanId()).orElseThrow();

        uplata.setClan(clan);
        uplata.setIznos(model.getIznos());
        uplata.setDatumUplate(model.getDatumUplate());

        return uplataRepository.save(uplata);
    }

    public void deleteUplata(Integer id) {
        uplataRepository.deleteById(id);
    }
}
