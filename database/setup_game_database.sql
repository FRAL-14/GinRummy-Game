create table players
(
    player_id serial
        constraint players_pk
            primary key,
    name      varchar(30) not null
);

create table game_sessions
(
    game_id         serial
        constraint game_sessions_pk
            primary key,
    human_player    int not null
        constraint game_sessions_players_human_player_id_fk
            references players (player_id),
    computer_player int not null
        constraint game_sessions_players_computer_player_id_fk
            references players (player_id),
    game_duration   int,
    winner          int
);

create table player_sessions
(
    game_id                int
        constraint player_sessions_game_sessions_game_id_fk
            references game_sessions (game_id),
    player_id              int
        constraint player_sessions_players_player_id_fk
            references players (player_id),
    player_score           int       not null,
    lowest_deadwood_count  int       not null,
    highest_deadwood_count int       not null,
    lowest_turn_duration   timestamp not null,
    avg_turn_duration      timestamp not null,
    highest_turn_duration  timestamp not null,
    most_valuable_turn     int       not null,
    most_valuable_round    int       not null,
    constraint player_sessions_pk
        primary key (game_id, player_id)
);
