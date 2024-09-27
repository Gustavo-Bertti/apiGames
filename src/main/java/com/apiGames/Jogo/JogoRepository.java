package com.apiGames.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
