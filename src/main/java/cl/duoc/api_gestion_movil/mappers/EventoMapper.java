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

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    Evento toEntity(EventoInputDTO inputDTO);

    // Al actualizar NO toca la organización ni el ID
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    void updateEntity(EventoUpdateDTO updateDTO, @MappingTarget Evento entity);
}