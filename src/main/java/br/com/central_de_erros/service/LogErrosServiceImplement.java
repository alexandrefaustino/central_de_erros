package br.com.central_de_erros.service;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogErros;
import br.com.central_de_erros.repository.LogErrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LogErrosServiceImplement implements LogErrosServiceInterface{

    @Autowired
    private LogErrosRepository logErrosRepository;

    @Override
    public long getSizeList(LevelError level, Pageable pageable) {
        return logErrosRepository.findByLevel(level, pageable).getTotalElements();
    }

    @Override
    public LogErros save(LogErros logErros) {
        return logErrosRepository.save(logErros);
    }

}
