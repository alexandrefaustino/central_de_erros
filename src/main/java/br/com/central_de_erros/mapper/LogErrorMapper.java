package br.com.central_de_erros.mapper;

import br.com.central_de_erros.dto.LogErrorDTO;
import br.com.central_de_erros.model.LogError;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogErrorMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "origin", target = "origin"),
            @Mapping(source = "details", target = "details"),
            @Mapping(source = "date", target = "date")
//            @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm")
    })
    LogErrorDTO map(LogError logError);

    List<LogErrorDTO> map(List<LogError> logErrors);

}
