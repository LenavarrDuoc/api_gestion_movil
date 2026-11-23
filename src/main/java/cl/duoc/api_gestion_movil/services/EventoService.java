package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.EventoMapper;
import cl.duoc.api_gestion_movil.models.Evento;
import cl.duoc.api_gestion_movil.models.Organizacion;
import cl.duoc.api_gestion_movil.repositories.EventoRepository;
import cl.duoc.api_gestion_movil.repositories.OrganizacionRepository;
import cl.duoc.api_gestion_movil.utils.LogUtil;
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
public class EventoService {

    private final EventoRepository repository;
    private final OrganizacionRepository organizacionRepository;
    private final EventoMapper mapper;

    @Transactional
    public EventoResponseDTO create(EventoInputDTO input) {
        log.info("Creando evento: {} para organizacion ID: {}", LogUtil.maskText(input.getTitulo()), input.getOrganizacionId());
        Evento entity = mapper.toEntity(input);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        Evento saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<EventoResponseDTO> findAll() {
        log.info("Listando eventos");
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventoResponseDTO findById(String id) {
        log.info("Buscando evento ID: {}", id);
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
    }

    @Transactional
    public EventoResponseDTO update(String id, EventoUpdateDTO input) {
        log.info("Actualizando evento ID: {}", id);
        Evento entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        mapper.updateEntity(input, entity);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void delete(String id) {
        log.info("Eliminando evento ID: {}", id);
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