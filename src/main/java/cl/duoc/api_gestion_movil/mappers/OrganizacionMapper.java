package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.OrganizacionInputDTO;
import cl.duoc.api_gestion_movil.dtos.OrganizacionResponseDTO;
import cl.duoc.api_gestion_movil.dtos.OrganizacionUpdateDTO;
import cl.duoc.api_gestion_movil.models.Organizacion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrganizacionMapper {
    OrganizacionResponseDTO toResponseDTO(Organizacion entity);
    Organizacion toEntity(OrganizacionInputDTO inputDTO);
    void updateEntity(OrganizacionUpdateDTO updateDTO, @MappingTarget Organizacion entity);
}