package br.com.central_de_erros.service;

import br.com.central_de_erros.dto.LogErrorPageDTO;
import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;
import br.com.central_de_erros.service.impl.LogErrorServiceImplement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class LogErrorServiceImplementTest {

    @Autowired
    private LogErrorServiceImplement serviceImplement;

//    @Autowired
//    private LogErrorRepository logErrorRepository;

    @Test
    public void findAllTest() {
        LogErrorPageDTO pageDTO = serviceImplement.findAllDTO(Pageable.unpaged());

        assertNotNull(pageDTO);

        long quantity = pageDTO.quantity;
        Long id = pageDTO.list.get(0).getId();
        LocalDateTime date = pageDTO.list.get(0).getDate();
        LevelError level = pageDTO.list.get(0).getLevel();
        String description = pageDTO.list.get(0).getDescription();
        String origin = pageDTO.list.get(0).getOrigin();
        assertEquals(9L, quantity);
        assertEquals(1L, id);
        assertEquals("2021-04-12T00:00", date.toString());
        assertEquals("erro de informação", description);
        assertEquals("INFO", level.toString());
        assertEquals("192.168.1.1", origin);
    }

    @Test
    public void findByIdTest() {
        Optional<LogError> logError = serviceImplement.findById(1L);

        assertNotNull(logError);

        Long id = logError.get().getId();
        LocalDateTime date = logError.get().getDate();
        LevelError level = logError.get().getLevel();
        String description = logError.get().getDescription();
        String origin = logError.get().getOrigin();
        String eventLog = logError.get().getEventLog();
        assertEquals(1L, id);
        assertEquals("2021-04-12T00:00", date.toString());
        assertEquals("erro de informação", description);
        assertEquals("INFO", level.toString());
        assertEquals("192.168.1.1", origin);
        assertEquals("cadastrarError()", eventLog);
    }

    @Test
    public void findByIdNullTest() {

        Optional<LogError> logErrorNull = serviceImplement.findById(10L);
        assertFalse(logErrorNull.isPresent());
    }

    @Test
    public void findByLevelTest() {
        LogErrorPageDTO page = serviceImplement.findByLevel(LevelError.valueOf("ERROR"), Pageable.unpaged());

        assertNotNull(page);

        long quantity = page.quantity;
        LevelError level = page.list.get(0).getLevel();
        assertEquals(3L, quantity);
        assertEquals("ERROR", level.toString());
    }
}
