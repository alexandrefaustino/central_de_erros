package br.com.central_de_erros.controller;

import br.com.central_de_erros.controller.adviced.ResourceNotFoundException;
import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.mapper.LogErrorMapper;
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

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/errors")
public class LogErrorController {

  @Autowired
  private LogErrorServiceInterface service;

  private LogErrorMapper mapper;

  @GetMapping
  public ResponseEntity<LogErrorPageDTO> findAll(Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(service.findAllDTO(pageable), HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation("Cria um novo Log de Erro")
  @ApiResponses(value = {@ApiResponse(code = 201, message = "Log de Erro criado com sucesso")})
  public ResponseEntity<LogError> create(@Valid @RequestBody LogError logError) {
    return new ResponseEntity<LogError>(this.service.save(logError), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  @ApiOperation("Busca Log de Erro por id")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Id não encontrado")})
  public ResponseEntity<LogError> findById(@PathVariable Long id) {
    return new ResponseEntity<LogError>(this.service.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("id não encontrado")), HttpStatus.OK);
  }

  @PostMapping("/search/date")
  @ApiOperation("Busca Log de Erro por data")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Data não encontrada")})
  public ResponseEntity<LogErrorPageDTO> findByDate(@RequestBody LocalDate localDate, Pageable pageable) {
    System.out.println(localDate.getClass());
    return new ResponseEntity<LogErrorPageDTO>(this.service.findByDate(localDate, pageable),HttpStatus.OK);
  }
}
