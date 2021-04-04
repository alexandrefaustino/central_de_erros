package br.com.central_de_erros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotBlank(message = "Campo obrigatório")
  private String name;

  @NotBlank(message = "Campo obrigatório")
  @Email
  private String email;

  @NotBlank(message = "Campo obrigatório")
  @Min(6)
  private String password;

  private boolean status;

}
