package br.com.central_de_erros.service.interfaces;

import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface LogErrorServiceInterface {

    Page<LogError> findAll(Pageable pageable);

    long getSizeList(LevelError level, Pageable pageable);

    LogError save(LogError logError);

    LogErrorPageDTO findAllDTO(Pageable pageable);
}
