package rs.ac.singidunum.f1_2025.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private Integer driver_number;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private LocalDateTime date_of_birth;

    @Column(nullable = false)
    private Integer debut_year;

    @Column(nullable = false)
    private Integer world_titles;

    @Column(nullable = false)
    private String profile_image;


    private Integer team_id;





}
