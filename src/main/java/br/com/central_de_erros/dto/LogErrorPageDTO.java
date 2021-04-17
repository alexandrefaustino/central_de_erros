package br.com.central_de_erros.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class LogErrorPageDTO {

    public long quantity;

    public List<LogErrorDTO> list;

    public LogErrorPageDTO(long quantity, List<LogErrorDTO> list) {
        this.quantity = quantity;
        this.list = list;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<LogErrorDTO> getList() {
        return list;
    }

    public void setList(List<LogErrorDTO> list) {
        this.list = list;
    }
}
