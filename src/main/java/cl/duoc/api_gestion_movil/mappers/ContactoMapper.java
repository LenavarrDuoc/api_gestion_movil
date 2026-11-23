package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.ContactoInputDTO;
import cl.duoc.api_gestion_movil.dtos.ContactoResponseDTO;
import cl.duoc.api_gestion_movil.dtos.ContactoUpdateDTO;
import cl.duoc.api_gestion_movil.models.Contacto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContactoMapper {

    @Mapping(source = "organizacion.id", target = "organizacionId")
    ContactoResponseDTO toResponseDTO(Contacto entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    Contacto toEntity(ContactoInputDTO inputDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    void updateEntity(ContactoUpdateDTO updateDTO, @MappingTarget Contacto entity);
}