package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.SeguimientoInputDTO;
import cl.duoc.api_gestion_movil.dtos.SeguimientoResponseDTO;
import cl.duoc.api_gestion_movil.dtos.SeguimientoUpdateDTO;
import cl.duoc.api_gestion_movil.models.Seguimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SeguimientoMapper {

    @Mapping(source = "oportunidad.id", target = "oportunidadId")
    @Mapping(source = "contacto.id", target = "contactoId")
    SeguimientoResponseDTO toResponseDTO(Seguimiento entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "oportunidad", ignore = true)
    @Mapping(target = "contacto", ignore = true)
    Seguimiento toEntity(SeguimientoInputDTO inputDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "oportunidad", ignore = true)
    @Mapping(target = "contacto", ignore = true)
    void updateEntity(SeguimientoUpdateDTO updateDTO, @MappingTarget Seguimiento entity);
}