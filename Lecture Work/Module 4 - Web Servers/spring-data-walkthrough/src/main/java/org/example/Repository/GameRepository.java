package org.example.Repository;

import org.example.Entity.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>
{
    public Game findByTitle(String title);

    public List<Game> findByPublisherAndDate(String publisher, String Date);

    public List <Game> findByGenreOrderByPublisherDesc(String genre);

    public long countByGenre (String genre);

    public long deleteByGenre(String genre);

    public List<Game> deleteByPublisher(String publisher);
}
