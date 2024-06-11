package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.clanModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service.ClanService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/clanovi")
@RequiredArgsConstructor
@CrossOrigin
public class ClanoviController {


    private final ClanService clanService;

    @GetMapping
    public List<Clan> getAllClanovi() {
        return clanService.getAllClanovi();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Clan> getClanoviById(@PathVariable Integer id) {
        return ResponseEntity.of(clanService.getClanById(id));
    }

    @GetMapping(path = "/ime/{ime}")
    public List<Clan> getClanoviByIme(@PathVariable String ime) {
        return (clanService.getClanByName(ime));
    }

    @PostMapping
    public Clan createClan(@RequestBody clanModel clan){
        return clanService.createClan(clan);
    }
    @PutMapping(path = "/{id}")
    Clan updateClan(@PathVariable Integer id, @RequestBody clanModel clan){
    return clanService.updateClan(id, clan);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletedClan(@PathVariable Integer id) {
        clanService.deletedClan(id);
    }

}
