package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.OrganizacionMapper;
import cl.duoc.api_gestion_movil.models.Organizacion;
import cl.duoc.api_gestion_movil.repositories.OrganizacionRepository;
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
public class OrganizacionService {
    private final OrganizacionRepository repository;
    private final OrganizacionMapper mapper;

    public OrganizacionResponseDTO create(OrganizacionInputDTO input) {
        log.info("Creando organizacion: {}", LogUtil.maskText(input.getNombre()));
        Organizacion saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<OrganizacionResponseDTO> findAll() {
        log.info("Consultando organizaciones");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public OrganizacionResponseDTO findById(Long id) {
        log.info("Buscando organizacion ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Organización no encontrada"));
    }

    public OrganizacionResponseDTO update(Long id, OrganizacionUpdateDTO input) {
        log.info("Actualizando organizacion ID: {}", id);
        Organizacion entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Organización no encontrada"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(Long id) {
        log.info("Eliminando organizacion ID: {}", id);
        repository.deleteById(id);
    }
}