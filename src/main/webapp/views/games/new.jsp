<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add a game</title>
  </head>
  <body>
    <form action="/games" method="post">
      <div>
        <label for="redTeamPlayer1Name">Red team player 1:</label>
        <input type="text" id="redTeamPlayer1Name" name="redTeamPlayer1Name" required />
      </div>
      <div>
        <label for="redTeamPlayer2">Red team player 2:</label>
        <input type="text" id="redTeamPlayer2" name="redTeamPlayer2" required />
      </div>
        <label for="redTeamScore">Red team score:</label>
        <input type="text" id="redTeamScore" name="redTeamScore" required />
      <div>
      <div>
        <label for="blueTeamPlayer1">Red team player 1:</label>
        <input type="text" id="blueTeamPlayer1" name="blueTeamPlayer1" required />
      </div>
      <div>
        <label for="blueTeamPlayer2">Red team player 2:</label>
        <input type="text" id="blueTeamPlayer2" name="blueTeamPlayer2" required />
      </div>
        <label for="redTeamScore">Red team score:</label>
        <input type="text" id="blueTeamScore" name="blueTeamScore" required />
      <div>
      </div>

       <input type="submit" value="Add game" />
    </form>
  </body>
</html>