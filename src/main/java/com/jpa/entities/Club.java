package com.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coach")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    @ManyToOne(targetEntity = FootballAssociation.class)
    @JoinColumn(name = "id_football_association")
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballCompetition.class)
    @JoinTable(
            name = "clubs_competition",
            joinColumns = @JoinColumn(name = "id_club"),
            inverseJoinColumns = @JoinColumn(name = "id_competition")
    )
    private List<FootballCompetition> footballCompetitions;

}
