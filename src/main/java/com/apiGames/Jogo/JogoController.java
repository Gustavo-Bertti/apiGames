package com.apiGames.Jogo;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jogos")
public class JogoController {

    final JogoService jogoService;

    JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }
    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoService.createJogo(jogo);
    }
    @GetMapping
    public List<Jogo> findAll() {
        return jogoService.findAll();
    }
    @GetMapping("/{id}")
    public Jogo findById(@PathVariable("id") Long id) {
        return jogoService.findById(id);
    }
    @GetMapping("/nome/{nome}")
    public List<Jogo> findByNome(@PathVariable("nome") String nome) {
        return jogoService.findByNome(nome);
    }
    @PutMapping("/{id}")
    public Jogo updateJogo(@PathVariable("id") Long id, @RequestBody Jogo jogo) {
        return jogoService.updateJogo(id, jogo);
    }
    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable("id") Long id) {
        jogoService.deleteJogo(id);
    }
}
