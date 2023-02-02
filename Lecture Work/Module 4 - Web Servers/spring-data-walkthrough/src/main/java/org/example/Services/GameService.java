package org.example.Services;

import org.example.Entity.Game;
import org.example.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService {
    @Autowired
    public GamesController(GameRepository gameRepository)
    {
        this.gameRepository = gameRepository;
    }

    public Game createGame (Game game)
    {
        return gameRepository.save(game);
}
