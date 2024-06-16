package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class clanModel {

    private String name;
    private String surname;
    private String email;
    private String brojTelefona;
    private String adresa;
    private Integer planId;
}
