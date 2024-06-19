package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity.Clan;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UplataModel {

    private Integer ClanId;
    private Double iznos;
    private LocalDate datumUplate;
}
