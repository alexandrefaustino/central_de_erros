package br.com.central_de_erros.controller;

import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.service.LogErrorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
