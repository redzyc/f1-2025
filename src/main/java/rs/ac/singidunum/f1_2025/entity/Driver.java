package rs.ac.singidunum.f1_2025.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
@Entity
@Table(name= "driver")
@NoArgsConstructor
@Setter
@Getter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="driver_id")
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer driverNumber;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private Integer debutYear;

    @Column(nullable = false)
    private Integer worldTitles;

    @Column(nullable = false)
    private String profileImage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @JsonIgnore
    private LocalDateTime deletedAt;





}
