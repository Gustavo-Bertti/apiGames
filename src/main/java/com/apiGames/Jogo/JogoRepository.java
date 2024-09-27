package com.apiGames.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    @Query("SELECT p FROM TB_JOGO p WHERE upper(p.nome) LIKE CONCAT('%', upper(:nome), '%')")
    List<Jogo> findByProductByName(@Param("nome") String name);
}
