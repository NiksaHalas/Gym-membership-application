package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity(name = "clanovi")
@NoArgsConstructor
@Getter
@Setter

public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clan_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @ManyToOne(optional = false)
    @JoinColumn(name ="planovi_id", nullable = false)
    private Plan plan;


    @Column(name = "broj_telefona", nullable = false)
    private String broj_telefona;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;


    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;


}
