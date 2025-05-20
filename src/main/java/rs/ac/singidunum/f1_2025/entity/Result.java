package rs.ac.singidunum.f1_2025.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

enum ResultStatus {
    FINISHED,
    DNF,
    DSQ,
    DNS,
    NC,
    RETIRED,
    LAP_DOWN
}
@Entity
@Table(name= "result")
@NoArgsConstructor
@Setter
@Getter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="result_id")
    private Integer id;

    private Integer driver_id;

    private Integer race_id;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer starting_position;

    @Column(nullable = false)
    private Integer laps_completed;

    @Column(nullable = false)
    private Integer pit_stops;

    @Column(nullable = false)
    private String time_gap;

    @Column(nullable = false)
    private ResultStatus status;

    @JsonIgnore
    private LocalDateTime deletedAt;




}
