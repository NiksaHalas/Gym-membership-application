package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Plan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.clanModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository.ClanoviRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClanService {

    private final ClanoviRepository repository;
    private final PlanService planService;
    private final ClanoviRepository clanoviRepository;

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
        clan.setPlan(plan);

        LocalDateTime endDate = LocalDateTime.now().plusDays(plan.getTrajanje());
        clan.setEndDate(LocalDate.from(endDate));

        return  repository.save(clan);
    }

    public Clan updateClan(Integer id, clanModel model) {
        Clan clan = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        Plan plan = planService.getPlanById(model.getPlanId()).orElseThrow();
        clan.setIme(model.getName());
        clan.setPrezime(model.getSurname());
        clan.setBroj_telefona(model.getBrojTelefona());
        clan.setPlan(plan);
    clan.setUpdatedAt(LocalDateTime.now());

        LocalDateTime endDate = LocalDateTime.now().plusDays(plan.getTrajanje());
        clan.setEndDate(LocalDate.from(endDate));

    return repository.save(clan);
    }

    public void deletedClan(Integer id) {

    Clan clan = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
    clan.setDeletedAt(LocalDateTime.now());
    repository.save(clan);

    }


    public Clan IzracunajEndDate(Clan clan) {
        Plan plan = clan.getPlan();
        if (plan != null) {
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(plan.getTrajanje());
            clan.setEndDate(endDate);
        }
        return repository.save(clan);
    }


}
