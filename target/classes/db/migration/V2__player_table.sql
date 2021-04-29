CREATE TABLE players (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
wins INTEGER,
losses INTEGER
);

ALTER TABLE games
DROP COLUMN red_team_player_1;

ALTER TABLE games
ADD COLUMN red_team_player_1_id INTEGER NOT NULL REFERENCES players(id);