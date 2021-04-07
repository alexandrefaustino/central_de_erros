package br.com.central_de_erros.repository;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogErros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LogErrosRepository extends JpaRepository<LogErros, Long> {
    Page<LogErros> findAll(Pageable pageable);

    Page<LogErros> findByLevel(LevelError level, Pageable pageable);

    Page<LogErros> findByDescription(String description, Pageable pageable);

    Page<LogErros> findByOrigin(String origin, Pageable pageable);

    Page<LogErros> findByDetails(String details, Pageable pageable);

    Page<LogErros> findByDate(LocalDateTime date, Pageable pageable);
}