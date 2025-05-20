package rs.ac.singidunum.f1_2025.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
enum RaceType {
    SPRINT,
    RACE
}
@Entity
@Table(name= "race")
@NoArgsConstructor
@Setter
@Getter
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="race_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private BigDecimal lapLengthKm;

    @Column(nullable = false)
    private Integer lapCount;

    @Column(nullable = false)
    private BigDecimal totalDistanceKm;

    @Column(nullable = false)
    private String trackType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
