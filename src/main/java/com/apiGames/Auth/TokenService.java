package com.apiGames.Auth;


import com.apiGames.Usuario.Usuario;
import com.apiGames.Usuario.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public static final Algorithm ALGORITHM = Algorithm.HMAC256("assinatura");

    private final UsuarioRepository usuarioRepository;

    public TokenService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Token gerarToken(String email){

        var expirationAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));
        String token = JWT.create()
                .withSubject(email)
                .withExpiresAt(expirationAt)
                .withIssuer("ApiGames")
                .sign(ALGORITHM);

        return new Token(token, email);

    }

    public Usuario getUserFromToken(String token) {
        var email = JWT.require(ALGORITHM)
                .withIssuer("ApiGames")
                .build()
                .verify(token)
                .getSubject();

        return usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
