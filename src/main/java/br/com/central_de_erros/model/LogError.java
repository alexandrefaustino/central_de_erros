package br.com.central_de_erros.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class LogError {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @NotNull
  private LevelError level;

  @NotBlank(message = "Campo obrigatório")
  private String description;

  @NotBlank(message = "Campo obrigatório")
  private String origin;

  @NotBlank(message = "Campo obrigatório")
  private String eventLog;

  private String details;

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

  public String getEventLog() {
    return eventLog;
  }

  public void setEventLog(String eventLog) {
    this.eventLog = eventLog;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

//  @PrePersist
//  public  void createDate() {
//    this.date = new ;
//  }
}
