package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Plan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.clanModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository.ClanoviRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClanService {

    private final ClanoviRepository repository;
    private final PlanService planService;

    public List<Clan> getAllClanovi() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Clan> getClanById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public List<Clan> getClanByName(String ime) {
        return repository.findByImeContainsAndDeletedAtIsNull(ime);
    }

    public Clan createClan(clanModel model) {
        Plan plan = planService.getPlanById(model.getPlanId()).orElseThrow();
        Clan clan = new Clan();
        clan.setBroj_telefona(model.getBrojTelefona());
        clan.setIme(model.getName());
        clan.setPrezime(model.getSurname());
        clan.setEmail(model.getEmail());
        clan.setAdresa(model.getAdresa());
        clan.setPlan(plan);
        return  repository.save(clan);
    }

    public Clan updateClan(Integer id, clanModel model) {
        Clan clan = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        Plan plan = planService.getPlanById(model.getPlanId()).orElseThrow();
        clan.setIme(model.getName());
        clan.setPrezime(model.getSurname());
        clan.setEmail(model.getEmail());
        clan.setBroj_telefona(model.getBrojTelefona());
        clan.setAdresa(model.getAdresa());
        clan.setPlan(plan);
    clan.setUpdatedAt(LocalDateTime.now());
    return repository.save(clan);
    }
    
    public void deletedClan(Integer id) {

    Clan clan = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
    clan.setDeletedAt(LocalDateTime.now());
    repository.save(clan);

    }
}