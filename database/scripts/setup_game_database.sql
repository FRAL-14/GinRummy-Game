create table players
(
    player_id serial constraint players_pk primary key,
    name      varchar(30) not null
);

create table game_sessions
(
    game_id serial constraint game_sessions_pk  primary key,
    human_player    int not null
        constraint game_sessions_players_human_player_id_fk
            references players (player_id),
    computer_player int not null
        constraint game_sessions_players_computer_player_id_fk
            references players (player_id),
    start_time time,
    end_time time,
    game_duration interval,
    winner          int
);

create table player_sessions
(
    game_id    int
        constraint player_sessions_game_sessions_game_id_fk
            references game_sessions (game_id),
    player_id  int
        constraint player_sessions_players_player_id_fk
            references players (player_id),
    player_score           int,
    lowest_deadwood_count  int,
    highest_deadwood_count int,
    lowest_turn_duration   timestamp,
    avg_turn_duration      timestamp,
    highest_turn_duration  timestamp,
    most_valuable_turn     int,
    most_valuable_round    int,
    constraint player_sessions_pk
        primary key (game_id, player_id)
);