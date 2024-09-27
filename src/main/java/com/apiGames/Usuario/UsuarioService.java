package com.apiGames.Usuario;

import com.apiGames.Comentario.Comentario;
import com.apiGames.Comentario.ComentarioService;
import com.apiGames.Comentario.Dto.ComentarioRequest;
import com.apiGames.Jogo.JogoRepository;
import com.apiGames.Jogo.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;
    final JogoService jogoservice;
    final ComentarioService comentarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, JogoService jogoService, ComentarioService comentarioService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jogoservice = jogoService;
        this.comentarioService = comentarioService;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario createUsuario(Usuario usuario) {
        String senhaCodificada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCodificada);
        return usuarioRepository.save(usuario);
    }

    public Usuario addComentarioInGame(Long idUsuario, Long idJogo, ComentarioRequest comentarioRequest) {
        var usuario = findById(idUsuario);
        var jogo = jogoservice.findById(idJogo);
        Comentario comentario = new Comentario();
        comentario.setUsuario(usuario);
        comentario.setJogo(jogo);
        comentario.setNome(comentarioRequest.nome());
        comentario.setDescricao(comentarioRequest.descricao());
        comentarioService.createComentario(comentario);
        return usuario;
    }


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setIdUsuario(id);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.deleteById(id);
    }
}
