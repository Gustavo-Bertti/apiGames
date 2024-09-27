package com.apiGames.Auth;


import com.apiGames.Usuario.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public Token login(Credenciais credenciais) {
        var user = usuarioRepository.findByEmail(credenciais.email())
                .orElseThrow(() -> {
                    System.out.println("Usuário não encontrado: " + credenciais.email());
                    return new RuntimeException("Acesso negado");
                });

        if (!passwordEncoder.matches(credenciais.senha(), user.getSenha())) {
            System.out.println("Senha incorreta para o usuário: " + credenciais.email());
            throw new RuntimeException("Acesso negado");
        }

        return tokenService.gerarToken(credenciais.email());
    }

}
