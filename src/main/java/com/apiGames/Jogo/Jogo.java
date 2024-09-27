package com.apiGames.Jogo;


import com.apiGames.Comentario.Comentario;
import com.apiGames.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;


@Data
@Entity(name = "TB_JOGO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogo;

    @NotBlank
    private String nome;

    @Min(0)
    @Max(10)
    private int nota;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


}
