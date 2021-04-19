package br.com.central_de_erros.service.interfaces;

import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface LogErrorServiceInterface {

    Page<LogError> findAll(Pageable pageable);

    Optional <LogError> findById(Long id);

    LogError save(LogError logError);

    LogErrorPageDTO findAllDTO(Pageable pageable);

    LogErrorPageDTO findByDate(LocalDate date, Pageable pageable);

    LogErrorPageDTO findByLevel(LevelError query, Pageable pageable);

    LogErrorPageDTO findByDescription(String query, Pageable pageable);

    LogErrorPageDTO findByOrigin(String query, Pageable pageable);

    LogErrorPageDTO findByDetails(String query, Pageable pageable);
}
