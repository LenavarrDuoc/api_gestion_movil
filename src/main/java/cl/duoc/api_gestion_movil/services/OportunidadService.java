package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.OportunidadMapper;
import cl.duoc.api_gestion_movil.models.Oportunidad;
import cl.duoc.api_gestion_movil.repositories.OportunidadRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OportunidadService {
    private final OportunidadRepository repository;
    private final OportunidadMapper mapper;

    public OportunidadResponseDTO create(OportunidadInputDTO input) {
        log.info("Creando oportunidad para organizacion ID: {}", input.getOrganizacionId());
        Oportunidad saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<OportunidadResponseDTO> findAll() {
        log.info("Listando oportunidades");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public OportunidadResponseDTO findById(Long id) {
        log.info("Buscando oportunidad ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Oportunidad no encontrada"));
    }

    public OportunidadResponseDTO update(Long id, OportunidadUpdateDTO input) {
        log.info("Actualizando oportunidad ID: {}", id);
        Oportunidad entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Oportunidad no encontrada"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(Long id) {
        log.info("Eliminando oportunidad ID: {}", id);
        repository.deleteById(id);
    }
}