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

    private Integer driverId;

    private Integer raceId;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Integer startingPosition;

    @Column(nullable = false)
    private Integer lapsCompleted;

    @Column(nullable = false)
    private Integer pitStops;

    @Column(nullable = false)
    private String timeGap;

    @Column(nullable = false)
    private ResultStatus status;

    @JsonIgnore
    private LocalDateTime deletedAt;




}
