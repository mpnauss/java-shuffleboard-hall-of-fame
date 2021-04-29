CREATE TABLE games (
id SERIAL PRIMARY KEY,
red_team_player_1 VARCHAR(255) NOT NULL,
red_team_player_2 VARCHAR(255) NOT NULL,
red_team_score INTEGER NOT NULL,
blue_team_player_1 VARCHAR(255) NOT NULL,
blue_team_player_2 VARCHAR(255) NOT NULL,
blue_team_score INTEGER NOT NULL
);