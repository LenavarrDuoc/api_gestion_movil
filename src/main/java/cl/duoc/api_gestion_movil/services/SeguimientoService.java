package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.SeguimientoMapper;
import cl.duoc.api_gestion_movil.models.Contacto;
import cl.duoc.api_gestion_movil.models.Oportunidad;
import cl.duoc.api_gestion_movil.models.Seguimiento;
import cl.duoc.api_gestion_movil.repositories.ContactoRepository;
import cl.duoc.api_gestion_movil.repositories.OportunidadRepository;
import cl.duoc.api_gestion_movil.repositories.SeguimientoRepository;
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
public class SeguimientoService {

    private final SeguimientoRepository repository;
    private final OportunidadRepository oportunidadRepository;
    private final ContactoRepository contactoRepository;
    private final SeguimientoMapper mapper;

    @Transactional
    public SeguimientoResponseDTO create(SeguimientoInputDTO input) {
        log.info("Registrando seguimiento por: {} para oportunidad ID: {}", LogUtil.maskEmail(input.getUsuarioEmail()), input.getOportunidadId());
        Seguimiento entity = mapper.toEntity(input);
        entity.setOportunidad(resolverOportunidad(input.getOportunidadId()));
        entity.setContacto(resolverContacto(input.getContactoId()));
        Seguimiento saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<SeguimientoResponseDTO> findAll() {
        log.info("Listando seguimientos");
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SeguimientoResponseDTO findById(Long id) {
        log.info("Buscando seguimiento ID: {}", id);
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
    }

    @Transactional
    public SeguimientoResponseDTO update(Long id, SeguimientoUpdateDTO input) {
        log.info("Actualizando seguimiento ID: {}", id);
        Seguimiento entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
        mapper.updateEntity(input, entity);
        entity.setOportunidad(resolverOportunidad(input.getOportunidadId()));
        entity.setContacto(resolverContacto(input.getContactoId()));
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        log.info("Eliminando seguimiento ID: {}", id);
        repository.deleteById(id);
    }

    private Oportunidad resolverOportunidad(Long oportunidadId) {
        if (oportunidadId == null || oportunidadId <= 0) {
            throw new IllegalArgumentException("El ID de la oportunidad es obligatorio para el seguimiento");
        }
        return oportunidadRepository.findById(oportunidadId)
                .orElseThrow(() -> new EntityNotFoundException("Oportunidad no encontrada con ID: " + oportunidadId));
    }

    private Contacto resolverContacto(Long contactoId) {
        if (contactoId == null || contactoId <= 0) {
            return null;
        }
        return contactoRepository.findById(contactoId)
                .orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado con ID: " + contactoId));
    }
}