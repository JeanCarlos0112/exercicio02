-- Remove a tabela "jogos" caso já exista
DROP TABLE IF EXISTS jogos;

-- Cria a tabela "jogos" com 4 colunas
CREATE TABLE jogos (
    codigo INT PRIMARY KEY,
    nome TEXT NOT NULL,
    empresa TEXT NOT NULL,
    quantidade INT
);

-- Insere 10 registros de exemplo
INSERT INTO jogos (codigo, nome, empresa, quantidade) VALUES
(1, 'FIFA 23', 'EA Sports', 150),
(2, 'Call of Duty: Modern Warfare II', 'Activision', 200),
(3, 'Valorant', 'Riot Games', 120),
(4, 'Fortnite', 'Epic Games', 300),
(5, 'Apex Legends', 'Respawn Entertainment', 180),
(6, 'Genshin Impact', 'miHoYo', 250),
(7, 'League of Legends', 'Riot Games', 400),
(8, 'Counter-Strike: Global Offensive', 'Valve', 220),
(9, 'Overwatch 2', 'Blizzard Entertainment', 130),
(10, 'Elden Ring', 'FromSoftware', 270);