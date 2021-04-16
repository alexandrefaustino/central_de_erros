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
import java.time.LocalDateTime;
import java.util.List;


@Service
public class LogErrorServiceImplement implements LogErrorServiceInterface {

    @Autowired
    private LogErrorRepository logErrorRepository;

    @Override
    public Page<LogError> findAll(Pageable pageable) {
        return logErrorRepository.findAll(pageable);
    }

    @Override
    public long getSizeList(LevelError level, Pageable pageable) {
        return logErrorRepository.findByLevel(level, pageable).getTotalElements();
    }

    @Override
    public LogError save(LogError logError) {
        logError.setDate(LocalDateTime.now());
        return logErrorRepository.save(logError);
    }

    @Override
    public LogErrorPageDTO findAllDTO(Pageable pageable) {
        Page<LogError> logErrorPage = this.findAll(pageable);
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        long quantity = logErrorPage.getTotalElements();
        List<LogErrorDTO> logErrorList= LogErrorDTO.convert(logErrorPage.getContent());
        return new LogErrorPageDTO(quantity, logErrorList);
    }

}
