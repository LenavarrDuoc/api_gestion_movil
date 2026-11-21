package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.mappers.ContactoMapper;
import cl.duoc.api_gestion_movil.models.Contacto;
import cl.duoc.api_gestion_movil.repositories.ContactoRepository;
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
public class ContactoService {
    private final ContactoRepository repository;
    private final ContactoMapper mapper;

    public ContactoResponseDTO create(ContactoInputDTO input) {
        log.info("Creando contacto: {} para organizacion ID: {}", LogUtil.maskText(input.getNombre()), input.getOrganizacionId());
        Contacto saved = repository.save(mapper.toEntity(input));
        return mapper.toResponseDTO(saved);
    }

    public List<ContactoResponseDTO> findAll() {
        log.info("Consultando contactos");
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public ContactoResponseDTO findById(Long id) {
        log.info("Buscando contacto ID: {}", id);
        return repository.findById(id).map(mapper::toResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado"));
    }

    public ContactoResponseDTO update(Long id, ContactoUpdateDTO input) {
        log.info("Actualizando contacto ID: {}", id);
        Contacto entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado"));
        mapper.updateEntity(input, entity);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public void delete(Long id) {
        log.info("Eliminando contacto ID: {}", id);
        repository.deleteById(id);
    }
}