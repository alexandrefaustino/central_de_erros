package br.com.central_de_erros.repository;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogErrorRepository extends JpaRepository<LogError, Long> {
    Page<LogError> findAll(Pageable pageable);

    Page<LogError> findByLevel(LevelError level, Pageable pageable);

    Page<LogError> findByDescriptionContaining(String description, Pageable pageable);

    Page<LogError> findByOriginContaining(String origin, Pageable pageable);

    Page<LogError> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
