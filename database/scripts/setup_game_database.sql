/************************************************/

create table IF NOT EXISTS players
(
    player_id serial constraint players_pk primary key,
    name      varchar(30)
    );

create table IF NOT EXISTS game
(
    game_id serial constraint game_pk  primary key,
    player_id    int not null constraint player_id_fk references players (player_id),
    start_time timestamp,
    end_time timestamp,
    duration numeric
    );

create table IF NOT EXISTS moves
(
    game_id    int constraint game_id_fk references game (game_id),
    player_id  int constraint player_id_fk references players (player_id),
    move_number int,
    deadwood   int CHECK(deadwood>=0),
    start_time timestamp,
    end_time   timestamp,
    duration numeric
    );

