package br.com.central_de_erros.controller;

import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.service.interfaces.LogErrorServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/errors")
public class LogErrorController {

  @Autowired
  private LogErrorServiceInterface service;

  @GetMapping
  public List<LogError> findAll(Pageable pageable) {
    return service.findAll(pageable).getContent();
  }

  @PostMapping
  @ApiOperation("Cria um novo Log de Erro")
  @ApiResponses(value = {@ApiResponse(code = 201, message = "Log de Erro criado com sucesso")})
  public ResponseEntity<LogError> create(@Valid @RequestBody LogError logError) {
    return  new ResponseEntity<LogError>(this.service.save(logError), HttpStatus.CREATED);
  }

//  @PostMapping
//  @ApiOperation("Cria um novo livro")
//  @ApiResponses(value = {@ApiResponse(code = 201, message = "Livro criado com sucesso")})
//  public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
//    return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);
//  }
}
