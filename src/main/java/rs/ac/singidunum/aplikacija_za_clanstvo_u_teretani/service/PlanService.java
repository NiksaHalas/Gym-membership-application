package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Plan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.PlanModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.repository.PlanRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanService {

   private final PlanRepository planRepository;

   public List<Plan> getAllPlan() {
       return planRepository.findAllByDeletedAtIsNull();
   }

   public Optional<Plan> getPlanById(Integer id) {
    return planRepository.findByIdAndDeletedAtIsNull(id);
   }

   public Plan savePlan(PlanModel model) {
    Plan plan = new Plan();
    plan.setNaziv(model.getNaziv());
    plan.setCena(model.getCena());
    plan.setCreatedAt(LocalDateTime.now());
    return planRepository.save(plan);
   }

    public Plan updatePlan(Integer id, PlanModel model) {
        Plan plan = planRepository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        plan.setNaziv(model.getNaziv());
        plan.setCena(model.getCena());
        plan.setUpdatedAt(LocalDateTime.now());
        return planRepository.save(plan);
    }

    public void deletePlan(Integer id) {
        Plan plan = planRepository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        plan.setDeletedAt(LocalDateTime.now());
        planRepository.save(plan);
    }

}
