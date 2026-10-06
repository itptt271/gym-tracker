CREATE TABLE IF NOT EXISTS exercises(
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    name         TEXT     NOT NULL UNIQUE,
    muscle_group TEXT     NOT NULL
);