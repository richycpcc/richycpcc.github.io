package io.catalyte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.catalyte.entities.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
//    public Game findByTitle(String title);

  //  public List<Game> findByPublisherAndDate (String publisher, String date);
}
