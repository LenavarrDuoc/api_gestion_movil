package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.EventoMapper;
import cl.duoc.api_gestion_movil.models.Evento;
import cl.duoc.api_gestion_movil.repositories.EventoRepository;
import cl.duoc.api_gestion_movil.utils.LogUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository repository;
    private final EventoMapper mapper;

    public EventoResponseDTO create(EventoInputDTO input) {
        log.info("Creando evento: {} para organizacion ID: {}", LogUtil.maskText(input.getTitulo()), input.getOrganizacionId());
        Evento saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<EventoResponseDTO> findAll() {
        log.info("Listando eventos");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public EventoResponseDTO findById(String id) {
        log.info("Buscando evento ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
    }

    public EventoResponseDTO update(String id, EventoUpdateDTO input) {
        log.info("Actualizando evento ID: {}", id);
        Evento entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(String id) {
        log.info("Eliminando evento ID: {}", id);
        repository.deleteById(id);
    }
}