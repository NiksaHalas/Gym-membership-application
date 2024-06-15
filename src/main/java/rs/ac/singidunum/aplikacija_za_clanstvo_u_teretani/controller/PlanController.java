package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Plan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.PlanModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service.PlanService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/planovi")
public class PlanController {

    private final PlanService service;

    @GetMapping
    public List<Plan> getAll() {
        return service.getAllPlan();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Plan> getById(@PathVariable Integer id) {
       return ResponseEntity.of(service.getPlanById(id));
    }

    @PostMapping
    public Plan create(@RequestBody PlanModel model) {
        return service.savePlan(model);
    }

    @PutMapping(path = "/{id}")
    public Plan update(@PathVariable Integer id, @RequestBody PlanModel model) {
        return service.updatePlan(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletePlan(id);
    }
}
