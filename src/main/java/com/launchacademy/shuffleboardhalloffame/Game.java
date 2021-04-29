package com.launchacademy.shuffleboardhalloffame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Game {
  @Id
  @SequenceGenerator(name="games_generator", sequenceName = "games_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_generator")
  @Column(name="id")
  private long id;

  @Column(name="red_team_player_1_id", nullable = false, unique = true, insertable = false)
  private Long redTeamPlayer1Id;

  @ManyToOne
  @JoinColumn(name="red_team_player_1_id", nullable = false, insertable = false, updatable = false)
  private Player redTeamPlayer1;

  @Column(name="red_team_player_2", nullable = false)
  private String redTeamPlayer2;

  @Column(name="red_team_score", nullable = false)
  private int redTeamScore;

  @Column(name="blue_team_player_1", nullable = false)
  private String blueTeamPlayer1;

  @Column(name="blue_team_player_2", nullable = false)
  private String blueTeamPlayer2;

  @Column(name="blue_team_score", nullable = false)
  protected int blueTeamScore;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getRedTeamPlayer1Id() {
    return redTeamPlayer1Id;
  }

  public void setRedTeamPlayer1Id(Long redTeamPlayer1Id) {
    this.redTeamPlayer1Id = redTeamPlayer1Id;
  }

  public Player getRedTeamPlayer1() {
    return redTeamPlayer1;
  }

  public void setRedTeamPlayer1(Player redTeamPlayer1) {
    this.redTeamPlayer1 = redTeamPlayer1;
  }

  public String getRedTeamPlayer2() {
    return redTeamPlayer2;
  }

  public void setRedTeamPlayer2(String redTeamPlayer2) {
    this.redTeamPlayer2 = redTeamPlayer2;
  }

  public int getRedTeamScore() {
    return redTeamScore;
  }

  public void setRedTeamScore(int redTeamScore) {
    this.redTeamScore = redTeamScore;
  }

  public String getBlueTeamPlayer1() {
    return blueTeamPlayer1;
  }

  public void setBlueTeamPlayer1(String blueTeamPlayer1) {
    this.blueTeamPlayer1 = blueTeamPlayer1;
  }

  public String getBlueTeamPlayer2() {
    return blueTeamPlayer2;
  }

  public void setBlueTeamPlayer2(String blueTeamPlayer2) {
    this.blueTeamPlayer2 = blueTeamPlayer2;
  }

  public int getBlueTeamScore() {
    return blueTeamScore;
  }

  public void setBlueTeamScore(int blueTeamScore) {
    this.blueTeamScore = blueTeamScore;
  }

  public String getWinner() {
    if (redTeamScore > blueTeamScore) {
      return "Red team won.";
    } else if ( blueTeamScore > redTeamScore) {
      return "Blue team won.";
    } else {
      return "Tie game.";
    }
  }
}
