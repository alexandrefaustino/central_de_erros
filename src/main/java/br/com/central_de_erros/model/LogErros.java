package br.com.central_de_erros.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class LogErros {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Enumerated(EnumType.STRING)
  private LevelError level;

  @NotBlank(message = "Campo obrigatório")
  private String description;

  @NotBlank(message = "Campo obrigatório")
  private String origin;

  private String Details;

  private LocalDateTime data;

}
