package br.com.central_de_erros.service.impl;

import br.com.central_de_erros.dto.LogErrorDTO;
import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.repository.LogErrorRepository;
import br.com.central_de_erros.service.interfaces.LogErrorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class LogErrorServiceImplement implements LogErrorServiceInterface {

    private LogErrorPageDTO formatLogPageDTO(Page<LogError> logErrorPage  ) {
        long quantity = logErrorPage.getTotalElements();
        List<LogErrorDTO> logErrorList= LogErrorDTO.convert(logErrorPage.getContent());
        return new LogErrorPageDTO(quantity, logErrorList);
    }

    @Autowired
    private LogErrorRepository logErrorRepository;

    @Override
    public Page<LogError> findAll(Pageable pageable) {
        return logErrorRepository.findAll(pageable);
    }

    @Override
    public Optional<LogError> findById(Long id)  {
        return logErrorRepository.findById(id);
    }

    @Override
    public LogError save(LogError logError) {
        logError.setDate(LocalDateTime.now());
        return logErrorRepository.save(logError);
    }

    @Override
    public LogErrorPageDTO findAllDTO(Pageable pageable) {
        Page<LogError> logErrorPage = this.findAll(pageable);
        return formatLogPageDTO(logErrorPage);
    }

    @Override
    public LogErrorPageDTO findByDate(LocalDate localDate, Pageable pageable) {
        Page<LogError> logErrorPage = logErrorRepository
                .findByDateBetween(localDate.atStartOfDay(), localDate.atTime(23, 59,59,59), pageable);
        return formatLogPageDTO(logErrorPage);
    }

    @Override
    public LogErrorPageDTO findByLevel(LevelError query, Pageable pageable) {
        Page<LogError> logErrorPage = logErrorRepository.findByLevel(query, pageable);
        return formatLogPageDTO(logErrorPage);
    }

    @Override
    public LogErrorPageDTO findByDescription(String query, Pageable pageable) {
        Page<LogError> logErrorPage = logErrorRepository.findByDescriptionContaining(query, pageable);
        return formatLogPageDTO(logErrorPage);
    }

    @Override
    public LogErrorPageDTO findByOrigin(String query, Pageable pageable) {
        Page<LogError> logErrorPage = logErrorRepository.findByOriginContaining(query, pageable);
        return formatLogPageDTO(logErrorPage);
    }

}
