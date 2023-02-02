package io.catalyte.Services;

import io.catalyte.repositories.GameRepository;
import io.catalyte.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService
{
    private GameRepository gameRepository;

    @Autowired
    public GameService (GameRepository gameRepository)
    {
        this.gameRepository = gameRepository;
    }
    public Game createGame (Game game)
    {
        return gameRepository.save(game);
    }
}
