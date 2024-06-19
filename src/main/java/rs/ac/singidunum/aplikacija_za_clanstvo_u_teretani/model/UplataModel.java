package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class UplataModel {

    private Integer ClanId;
    private Double iznos;
    private LocalDate datumUplate;
}
