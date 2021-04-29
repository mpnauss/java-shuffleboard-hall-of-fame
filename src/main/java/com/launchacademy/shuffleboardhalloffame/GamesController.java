package com.launchacademy.shuffleboardhalloffame;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

@WebServlet(urlPatterns = {"/games/new" ,"/games"})
public class GamesController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    if (req.getServletPath().equalsIgnoreCase("/games/new")) {

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/new.jsp");

      dispatcher.forward(req, res);

    } else if (req.getServletPath().equalsIgnoreCase("/games")) {
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
//      TypedQuery<Game> gamesQuery = em.createQuery("SELECT g FROM Game g", Game.class);
//      List<Game> games = gamesQuery.getResultList();
//      System.out.println(games);
      GameService gameService = new GameService(em);
      List<Game> games = gameService.findAll();
      req.setAttribute("games", games);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/index.jsp");

      dispatcher.forward(req, res);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

    if (req.getServletPath().equalsIgnoreCase("/games")) {

//      PlayerService playerService = new PlayerService(em);
//
//      List<String> playerNames = new ArrayList<String>();
//      playerNames.add(req.getParameter("redTeamPlayer1"));
//      playerNames.add(req.getParameter("redTeamPlayer2"));
//      playerNames.add(req.getParameter("blueTeamPlayer1"));
//      playerNames.add(req.getParameter("blueTeamPlayer2"));
//
//      for(String playerName: playerNames)
//      if (!playerService.checkForPlayer(playerName)) {
//        playerService.addPlayer(playerName);
//      }

      PlayerService playerService = new PlayerService(em);
      Player player = new Player();
      player.setName(req.getParameter("redTeamPlayer1Name"));
//      System.out.println(player.getName());
//      System.out.println(player.getId());
      player.setWins(0);
      player.setLosses(0);
      try {
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        em.getTransaction().rollback();
      }

      Game game = new Game();
      try {
        BeanUtils.populate(game, req.getParameterMap());
        game.setRedTeamPlayer1(player);
        System.out.println(game.getRedTeamPlayer1().getName());
        System.out.println(game.getRedTeamPlayer1Id());
      } catch (IllegalAccessException | InvocationTargetException e) {
        System.out.println(e.getMessage());
      }

//      try {
//        em.getTransaction().begin();
//        em.persist(game);
//        em.getTransaction().commit();
//      } catch (Exception e) {
//        System.out.println("There was an error posting the data");
//        em.getTransaction().rollback();
//      } finally {
//        em.close();
//      }

      GameService gameService = new GameService(em);
      if(!gameService.save(game)) {
        System.out.println("Something went wrong.");
      }
//      req.setAttribute("game", game);
      res.sendRedirect("/games");
      em.close();
    } else {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }
}
