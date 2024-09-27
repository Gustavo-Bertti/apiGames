package com.apiGames.Comentario;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("comentarios")
public class ComentarioController {

    final ComentarioService comentarioService;

    ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return comentarioService.createComentario(comentario);
    }
    @GetMapping
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }
    @GetMapping("/{id}")
    public Comentario findById(@PathVariable("id") Long id) {
        return comentarioService.findById(id);
    }
    @PutMapping("/{id}")
    public Comentario updateComentario(@PathVariable("id") Long id, @RequestBody Comentario comentario) {
        return comentarioService.updateComentario(id, comentario);
    }
    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable("id") Long id) {
        comentarioService.deleteComentario(id);
    }

}
