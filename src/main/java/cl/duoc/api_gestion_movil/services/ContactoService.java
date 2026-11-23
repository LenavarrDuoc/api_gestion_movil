package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.ContactoMapper;
import cl.duoc.api_gestion_movil.models.Contacto;
import cl.duoc.api_gestion_movil.models.Organizacion;
import cl.duoc.api_gestion_movil.repositories.ContactoRepository;
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
public class ContactoService {

    private final ContactoRepository repository;
    private final OrganizacionRepository organizacionRepository;
    private final ContactoMapper mapper;

    @Transactional
    public ContactoResponseDTO create(ContactoInputDTO input) {
        log.info("Creando contacto: {} para organizacion ID: {}", LogUtil.maskText(input.getNombre()), input.getOrganizacionId());
        Contacto entity = mapper.toEntity(input);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        Contacto saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<ContactoResponseDTO> findAll() {
        log.info("Consultando contactos");
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContactoResponseDTO findById(Long id) {
        log.info("Buscando contacto ID: {}", id);
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado"));
    }

    @Transactional
    public ContactoResponseDTO update(Long id, ContactoUpdateDTO input) {
        log.info("Actualizando contacto ID: {}", id);
        Contacto entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado"));
        mapper.updateEntity(input, entity);
        entity.setOrganizacion(resolverOrganizacion(input.getOrganizacionId()));
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        log.info("Eliminando contacto ID: {}", id);
        repository.deleteById(id);
    }

    private Organizacion resolverOrganizacion(Long organizacionId) {
        if (organizacionId == null || organizacionId <= 0) {
            throw new IllegalArgumentException("El ID de la organización es obligatorio para el contacto");
        }
        return organizacionRepository.findById(organizacionId)
                .orElseThrow(() -> new EntityNotFoundException("Organización no encontrada con ID: " + organizacionId));
    }
}