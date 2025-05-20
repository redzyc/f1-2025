package entity;

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
    private Integer founded_year;

    @Column(nullable = false)
    private String team_chef;

    @Column(nullable = false)
    private Integer championships;

    @Column(nullable = false)
    private String base_location;

    @Column(nullable = false)
    private String logo_url;

    @Column(nullable = false)
    private String engine_supplier;


    @Column(nullable = false)
    private String car_name;

}
