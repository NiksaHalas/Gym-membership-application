package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity(name = "placanja")
@NoArgsConstructor
@Getter
@Setter
public class Uplata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placanja_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clan_id", nullable = false)
    private Clan clan;

    @Column(name = "iznos",nullable = false)
    private Double iznos;

    @Column(name = "datum_uplate", nullable = false)
    private LocalDate datumUplate;


}
