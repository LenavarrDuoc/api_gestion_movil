package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.OportunidadInputDTO;
import cl.duoc.api_gestion_movil.dtos.OportunidadResponseDTO;
import cl.duoc.api_gestion_movil.dtos.OportunidadUpdateDTO;
import cl.duoc.api_gestion_movil.models.Oportunidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OportunidadMapper {

    @Mapping(source = "organizacion.id", target = "organizacionId")
    OportunidadResponseDTO toResponseDTO(Oportunidad entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    Oportunidad toEntity(OportunidadInputDTO inputDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    void updateEntity(OportunidadUpdateDTO updateDTO, @MappingTarget Oportunidad entity);
}