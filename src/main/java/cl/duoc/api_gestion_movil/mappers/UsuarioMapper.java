package cl.duoc.api_gestion_movil.mappers;

import cl.duoc.api_gestion_movil.dtos.UsuarioInputDTO;
import cl.duoc.api_gestion_movil.dtos.UsuarioResponseDTO;
import cl.duoc.api_gestion_movil.dtos.UsuarioUpdateDTO;
import cl.duoc.api_gestion_movil.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponseDTO toResponseDTO(Usuario entity);
    Usuario toEntity(UsuarioInputDTO inputDTO);
    void updateEntity(UsuarioUpdateDTO updateDTO, @MappingTarget Usuario entity);
}