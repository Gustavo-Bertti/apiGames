package com.apiGames.Comentario;

import com.apiGames.Jogo.Jogo;
import com.apiGames.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity(name = "TB_COMENTARIO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idJogo")
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
