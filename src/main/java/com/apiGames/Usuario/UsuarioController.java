package com.apiGames.Usuario;

import com.apiGames.Comentario.Dto.ComentarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    @PostMapping("/addComentario/{idUsuario}/jogos/{idJogo}")
    public Usuario addComentarioInGame(@RequestBody ComentarioRequest comentarioRequest, @PathVariable("idUsuario") Long idUsuario, @PathVariable("idJogo") Long idJogo) {
        return usuarioService.addComentarioInGame(idUsuario, idJogo, comentarioRequest);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuario(id);
    }
}
