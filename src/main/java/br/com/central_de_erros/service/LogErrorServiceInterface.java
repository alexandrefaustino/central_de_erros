package br.com.central_de_erros.service;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import org.springframework.data.domain.Pageable;

public interface LogErrorServiceInterface {
    long getSizeList(LevelError level, Pageable pageable);

    LogError save(LogError logError);

}
