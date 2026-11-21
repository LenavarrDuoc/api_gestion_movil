package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.EventoInputDTO;
import cl.duoc.api_gestion_movil.dtos.EventoResponseDTO;
import cl.duoc.api_gestion_movil.dtos.EventoUpdateDTO;
import cl.duoc.api_gestion_movil.models.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    @Mapping(source = "organizacion.id", target = "organizacionId")
    EventoResponseDTO toResponseDTO(Evento entity);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Evento toEntity(EventoInputDTO inputDTO);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    void updateEntity(EventoUpdateDTO updateDTO, @MappingTarget Evento entity);
}