package com.launchacademy.shuffleboardhalloffame;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="players")
public class Player {
  @Id
  @SequenceGenerator(name="players_generator", sequenceName = "players_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_generator")
  @Column(name="id", nullable = false, unique = true)
  private long id;

//  @NotEmpty
  @Column(name="name", nullable = false)
  private String name;

//  @Min(value = 0)
  @Column(name="wins")
  private int wins;

//  @Min(value = 0)
  @Column(name="losses")
  private int losses;

  public long getId() {
    return id;
  }

  @OneToMany(mappedBy = "redTeamPlayer1")
  private List<Game> games = new ArrayList<Game>();

  public List<Game> getGames() {
    return games;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }

  public void incrementWins() {
    this.wins += 1;
  }

  public void incrementLosses() {
    this.losses += 1;
  }
}
