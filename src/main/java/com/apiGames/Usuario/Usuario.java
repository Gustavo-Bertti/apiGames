
package com.apiGames.Usuario;

import com.apiGames.Jogo.Jogo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity(name = "TB_USUARIO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;


    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank
    @Size(min = 8, max = 100)
    private String senha;




}

