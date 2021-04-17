package br.com.central_de_erros.service.interfaces;

import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LogErrorServiceInterface {

    Page<LogError> findAll(Pageable pageable);

    Optional <LogError> findById(Long id);

    LogError save(LogError logError);

    LogErrorPageDTO findAllDTO(Pageable pageable);

    LogErrorPageDTO findByDateIsContaining(LocalDate date, Pageable pageable);
}
