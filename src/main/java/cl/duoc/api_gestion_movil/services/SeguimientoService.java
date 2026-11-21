package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.SeguimientoMapper;
import cl.duoc.api_gestion_movil.models.Seguimiento;
import cl.duoc.api_gestion_movil.repositories.SeguimientoRepository;
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
public class SeguimientoService {
    private final SeguimientoRepository repository;
    private final SeguimientoMapper mapper;

    public SeguimientoResponseDTO create(SeguimientoInputDTO input) {
        log.info("Registrando seguimiento por: {} para oportunidad ID: {}", LogUtil.maskEmail(input.getUsuarioEmail()), input.getOportunidadId());
        Seguimiento saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<SeguimientoResponseDTO> findAll() {
        log.info("Listando seguimientos");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public SeguimientoResponseDTO findById(Long id) {
        log.info("Buscando seguimiento ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
    }

    public SeguimientoResponseDTO update(Long id, SeguimientoUpdateDTO input) {
        log.info("Actualizando seguimiento ID: {}", id);
        Seguimiento entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(Long id) {
        log.info("Eliminando seguimiento ID: {}", id);
        repository.deleteById(id);
    }
}