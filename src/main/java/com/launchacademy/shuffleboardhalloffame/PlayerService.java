package com.launchacademy.shuffleboardhalloffame;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PlayerService {
  private EntityManager em;

  public PlayerService(EntityManager em) {
    this.em = em;
  }

  public boolean checkForPlayer(String playerName) {
    String playerQueryString = "SELECT p FROM Player p WHERE name = ':player'";
    TypedQuery<Player> playerQuery = em.createQuery(playerQueryString, Player.class);
    playerQuery.setParameter("player", playerName);
    List<Player> playersList = playerQuery.getResultList();
    if (playersList.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean addPlayer(String playerName) {
    Player player = new Player();
    player.setName(playerName);
    player.setWins(0);
    player.setLosses(0);
    try {
      em.getTransaction().begin();
      em.persist(player);
      em.getTransaction().commit();
      return true;
    } catch (Exception e){
      System.out.println(e.getMessage());
      em.getTransaction().rollback();
      return false;
    }
  }

//  public Player getPlayerByName(String name) {
//    String playerQueryString = "SELECT p FROM Player p WHERE name=':name'";
//    TypedQuery<Player> playerQuery = em.createQuery(playerQueryString, Player.class);
//    playerQuery.setParameter("name", name);
//    return playerQuery.getSingleResult();
//  }

}
