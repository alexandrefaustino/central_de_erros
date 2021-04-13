package br.com.central_de_erros.service;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.repository.LogErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
        return logErrorRepository.save(logError);
    }

}
