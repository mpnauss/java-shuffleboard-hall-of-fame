<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.launchacademy.shuffleboardhalloffame.Game" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add a game</title>
  </head>
  <body>
    <h1>Game info:</h1>
    <ul>
    <c:forEach items = "${requestScope.games}" var="game">
      <li>Red team player 1: <c:out value="${game.redTeamPlayer1}"/><br />
      Red team player 2: <c:out value="${game.redTeamPlayer2}"/><br />
      Red team score: <c:out value="${game.redTeamScore}"/><br />
      Blue team player 1: <c:out value="${game.blueTeamPlayer1}"/><br />
      Blue team player 2: <c:out value="${game.blueTeamPlayer2}"/><br />
      Blue team score: <c:out value="${game.blueTeamScore}"/><br />
      <c:out value="${game.winner}" />
      </li>
    </c:forEach>
    </ul>
  </body>
 </html>