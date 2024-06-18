package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UplataModel {

    private Integer id;
    private clanModel clan;
    private Double iznos;
    private LocalDateTime datumUplate;
}
