package br.com.central_de_erros.controller;

import br.com.central_de_erros.controller.adviced.ResourceNotFoundException;
import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.service.interfaces.LogErrorServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/errors")
public class LogErrorController {

  @Autowired
  private LogErrorServiceInterface service;

  @GetMapping
  @CrossOrigin(origins = "*")
  public ResponseEntity<LogErrorPageDTO> findAll(Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(service.findAllDTO(pageable), HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation("Cria um novo Log de Erro")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {@ApiResponse(code = 201, message = "Log de Erro criado com sucesso")})
  public ResponseEntity<LogError> create(@Valid @RequestBody LogError logError) {
    return new ResponseEntity<LogError>(this.service.save(logError), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  @ApiOperation("Busca Log de Erro por id")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Id não encontrado")})
  @CrossOrigin("*")
  public ResponseEntity<LogError> findById(@PathVariable Long id) {
    return new ResponseEntity<LogError>(this.service.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("id não encontrado")), HttpStatus.OK);
  }

  @GetMapping("/search/date/{query}")
  @ApiOperation("Busca Log de Erro por data")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Data não encontrada")})
  @CrossOrigin(origins = "*")
  public ResponseEntity<LogErrorPageDTO> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate query, Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(this.service.findByDate(query, pageable),HttpStatus.OK);
  }

  @GetMapping("/search/level/{query}")
  @ApiOperation("Busca Log de Erro por nível")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Nível não encontrado")
  })
  @CrossOrigin(origins = "*")
  public ResponseEntity<LogErrorPageDTO> searchByLevel(@PathVariable LevelError query,
                                                       Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(
            service.findByLevel(query, pageable),
            HttpStatus.OK
    );
  }

  @GetMapping("/search/description/{query}")
  @ApiOperation("Busca Log de Erro por descrição")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Descrição não encontrada")
  })
  @CrossOrigin(origins = "*")
  public ResponseEntity<LogErrorPageDTO> searchByDescription(@PathVariable String query,
                                                       Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(
            service.findByDescription(query, pageable),
            HttpStatus.OK
    );
  }

  @GetMapping("/search/origin/{query}")
  @ApiOperation("Busca Log de Erro por origem")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Log de Erro encontrado com sucesso"),
          @ApiResponse(code = 404, message = "Origem não encontrada")
  })
  @CrossOrigin(origins = "*")
  public ResponseEntity<LogErrorPageDTO> searchByOrigin(@PathVariable String query,
                                                       Pageable pageable) {
    return new ResponseEntity<LogErrorPageDTO>(
            service.findByOrigin(query, pageable),
            HttpStatus.OK
    );
  }

}
