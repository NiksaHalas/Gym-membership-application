package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Uplata;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model.UplataModel;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.service.UplataService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/uplate")
@RequiredArgsConstructor
@CrossOrigin
public class UplataController {

    private final UplataService uplataService;


    @GetMapping
    public List<Uplata> getAllUplate() {
        return uplataService.getAllUplate();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Uplata> getUplataById(@PathVariable Integer id) {
        return ResponseEntity.of(uplataService.getUplataById(id));
    }

    @GetMapping(path = "/clan/{clan_id}")
    public List<Uplata> getUplateByClanId(@PathVariable Integer clan_id) {
        return uplataService.getUplateByClanId(clan_id);
    }

    @GetMapping(path = "/iznos/{iznos}")
    public List<Uplata> getUplateByIznosGreaterThan(@PathVariable Double iznos) {
        return uplataService.getUplateByIznosGreaterThan(iznos);
    }

    @GetMapping(path = "/datum")
    public List<Uplata> getUplateBetweenDates(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return uplataService.getUplateBetweenDates(start, end);
    }

    @PostMapping
    public ResponseEntity<Uplata> createUplata(@RequestBody UplataModel model) {

            Uplata uplata = uplataService.createUplata(model);
            return ResponseEntity.ok(uplata);

    }

    @PutMapping(path = "/{id}")
    public Uplata updateUplata(@PathVariable Integer id, @RequestBody UplataModel uplata) {
        return uplataService.updateUplata(id, uplata);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUplata(@PathVariable Integer id) {
        uplataService.deleteUplata(id);
    }
}
