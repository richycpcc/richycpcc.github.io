package org.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
