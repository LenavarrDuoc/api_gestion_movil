package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.ContactoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/contactos")
@RequiredArgsConstructor
public class ContactoController {
    private final ContactoService service;

    @PostMapping
    public ResponseEntity<ContactoResponseDTO> create(@RequestBody ContactoInputDTO input) {
        log.info("Petición HTTP: POST /api/contactos");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactoResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/contactos");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoResponseDTO> findById(@PathVariable Long id) {
        log.info("Petición HTTP: GET /api/contactos/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoResponseDTO> update(@PathVariable Long id, @RequestBody ContactoUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/contactos/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Petición HTTP: DELETE /api/contactos/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}