package com.apiGames.Comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComentarioService {

    final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }
    public Comentario findById(Long id) {
        return comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentario não encontrado"));
    }

    public Comentario updateComentario(Long id, Comentario comentario) {
        comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
        comentario.setIdComentario(id);
        return comentarioRepository.save(comentario);
    }

    public void deleteComentario(Long id) {
        comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
        comentarioRepository.deleteById(id);
    }
}
