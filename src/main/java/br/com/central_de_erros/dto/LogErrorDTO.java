package br.com.central_de_erros.dto;

import br.com.central_de_erros.model.LevelError;
import br.com.central_de_erros.model.LogError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LogErrorDTO {

    private Long id;

    private LevelError level;

    private String description;

    private String origin;

    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LevelError getLevel() {
        return level;
    }

    public void setLevel(LevelError level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LogErrorDTO() {
    }

    public LogErrorDTO(LogError logError) {
        this.id = logError.getId();
        this.level = logError.getLevel();
        this.description = logError.getDescription();
        this.origin = logError.getOrigin();
        this.date = logError.getDate();
    }

    public static List<LogErrorDTO> convert(List<LogError> logErrors) {
        return logErrors.stream().map(LogErrorDTO::new).collect(Collectors.toList());
    }
}
