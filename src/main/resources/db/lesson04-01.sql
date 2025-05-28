DROP TABLE IF EXISTS player
;

CREATE TABLE player
(
    id          BIGSERIAL,
    login       VARCHAR(128) NOT NULL UNIQUE,
    password    VARCHAR(100) NOT NULL ,
    role        VARCHAR(50),
    game_points INT,
    date        DATE
);

INSERT INTO public.player
    (id, login, password, role, game_points, date)
VALUES
    (DEFAULT, 'Carl', 'admin', 'ADMIN',15,now()),
    (DEFAULT, 'Alisa', 'admin123', 'ADMIN',15,now()),
    (DEFAULT, 'Bob', 'admin1', 'ADMIN',15,now()),
    (DEFAULT, 'Mike', 'admin55555', 'ADMIN',15,now()),
    (DEFAULT, 'Bibik', 'admin4', 'ADMIN',15,now()),
    (DEFAULT, 'Ya', 'admin5', 'ADMIN',15,now())
;

