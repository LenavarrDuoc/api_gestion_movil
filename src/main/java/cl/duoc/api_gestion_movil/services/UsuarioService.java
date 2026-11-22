package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.UsuarioMapper;
import cl.duoc.api_gestion_movil.models.Usuario;
import cl.duoc.api_gestion_movil.repositories.UsuarioRepository;
import cl.duoc.api_gestion_movil.utils.LogUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.internal.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponseDTO create(UsuarioInputDTO input) {
        log.info("Creando nuevo usuario con email: {}", LogUtil.maskEmail(input.getEmail()));
        Usuario saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<UsuarioResponseDTO> findAll() {
        log.info("Obteniendo lista de usuarios");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public UsuarioResponseDTO findById(String id) {
        log.info("Buscando usuario ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
    }

    public UsuarioResponseDTO update(String id, UsuarioUpdateDTO input) {
        log.info("Actualizando usuario ID: {}", id);
        Usuario entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    // Agrega este méto.do dentro de tu UsuarioService existente

    public UsuarioResponseDTO updatePassword(String id, UsuarioPasswordUpdateDTO input) {
        log.info("Actualizando contraseña para usuario ID: {}", id);
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        mapper.updatePassword(input, entity);

        // IMPORTANTE: Si usas Spring Security, aquí debes encriptar la clave antes de guardar.
        // Ejemplo: entity.setPassword(passwordEncoder.encode(input.getPassword()));

        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(String id) {
        log.info("Eliminando usuario ID: {}", id);
        repository.deleteById(id);
    }


}