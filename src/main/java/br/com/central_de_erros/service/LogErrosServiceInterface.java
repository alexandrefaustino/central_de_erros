package br.com.central_de_erros.service;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogErros;
import org.springframework.data.domain.Pageable;

public interface LogErrosServiceInterface {
    long getSizeList(LevelError level, Pageable pageable);

    LogErros save(LogErros logErros);

}
