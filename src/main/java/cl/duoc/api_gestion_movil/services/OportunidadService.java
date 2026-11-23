package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.OportunidadMapper;
import cl.duoc.api_gestion_movil.models.Oportunidad;
import cl.duoc.api_gestion_movil.models.Organizacion;
import cl.duoc.api_gestion_movil.repositories.OportunidadRepository;
import cl.duoc.api_gestion_movil.repositories.OrganizacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OportunidadService {

    private final OportunidadRepository repository;
    private final OrganizacionRepository organizacionRepository;
    private final OportunidadMapper mapper;

    @Transactional
    public OportunidadResponseDTO create(OportunidadInputDTO input) {
        log.info("Creando oportunidad para organizacion ID: {}", input.getOrganizacionId());
        Oportunidad entity = mapper.toEntity(input);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        Oportunidad saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<OportunidadResponseDTO> findAll() {
        log.info("Listando oportunidades");
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OportunidadResponseDTO findById(Long id) {
        log.info("Buscando oportunidad ID: {}", id);
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Oportunidad no encontrada"));
    }

    @Transactional
    public OportunidadResponseDTO update(Long id, OportunidadUpdateDTO input) {
        log.info("Actualizando oportunidad ID: {}", id);
        Oportunidad entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Oportunidad no encontrada"));
        mapper.updateEntity(input, entity);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        log.info("Eliminando oportunidad ID: {}", id);
        repository.deleteById(id);
    }

    private Organizacion resolverOrganizacion(Long organizacionId) {
        if (organizacionId == null || organizacionId <= 0) {
            return null;
        }
        return organizacionRepository.findById(organizacionId)
                .orElseThrow(() -> new EntityNotFoundException("Organización no encontrada con ID: " + organizacionId));
    }
}