package br.com.central_de_erros.repository;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LogErrorRepository extends JpaRepository<LogError, Long> {
    Page<LogError> findAll(Pageable pageable);

    Page<LogError> findByLevel(LevelError level, Pageable pageable);

    Page<LogError> findByDescription(String description, Pageable pageable);

    Page<LogError> findByOrigin(String origin, Pageable pageable);

    Page<LogError> findByDetails(String details, Pageable pageable);

    Page<LogError> findByDate(LocalDateTime date, Pageable pageable);
}
