package rs.ac.singidunum.f1_2025.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name= "team")
@NoArgsConstructor
@Setter
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer foundedYear;

    @Column(nullable = false)
    private String teamChef;

    @Column(nullable = false)
    private Integer championships;

    @Column(nullable = false)
    private String baseLocation;

    @Column(nullable = false)
    private String logoUrl;

    @Column(nullable = false)
    private String engineSupplier;


    @Column(nullable = false)
    private String carName;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
