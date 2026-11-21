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

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Oportunidad toEntity(OportunidadInputDTO inputDTO);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    void updateEntity(OportunidadUpdateDTO updateDTO, @MappingTarget Oportunidad entity);
}