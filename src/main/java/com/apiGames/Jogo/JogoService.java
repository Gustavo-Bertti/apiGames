package com.apiGames.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JogoService {

    final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo createJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }
    public Jogo findById(Long id) {
        return jogoRepository.findById(id).orElseThrow(()-> new RuntimeException("Jogo não encontrado"));
    }

    public Jogo updateJogo(Long id, Jogo jogo) {
        jogoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
        jogo.setIdJogo(id);
        return jogoRepository.save(jogo);
    }

    public void deleteJogo(Long id) {
        jogoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
        jogoRepository.deleteById(id);
    }
}
