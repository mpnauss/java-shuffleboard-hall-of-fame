package com.launchacademy.shuffleboardhalloffame;

import antlr.debug.SemanticPredicateListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GameService {
  private EntityManager em;

  public GameService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Game game) {
    try {
      em.getTransaction().begin();
      em.persist(game);
      em.getTransaction().commit();
      return true;
    } catch (Exception e){
      System.out.println(e.getMessage());
      em.getTransaction().rollback();
      return false;
    }
  }

  public List<Game> findAll() {
    TypedQuery<Game> gamesQuery = em.createQuery("SELECT g FROM Game g", Game.class);
    List<Game> games = gamesQuery.getResultList();
    return games;
  }

}
