package br.com.central_de_erros.repository;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogErros;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LogErrosRepository extends JpaRepository<LogErros, Long> {
    Page<LogErros> findByLevel(LevelError level);

    Page<LogErros> findByDescription(String description);

    Page<LogErros> findByOrigin(String origin);

    Page<LogErros> findByDetails(String details);

    Page<LogErros> findByDate(LocalDateTime date);
}
