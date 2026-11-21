package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.OportunidadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/oportunidades")
@RequiredArgsConstructor
public class OportunidadController {
    private final OportunidadService service;

    @PostMapping
    public ResponseEntity<OportunidadResponseDTO> create(@RequestBody OportunidadInputDTO input) {
        log.info("Petición HTTP: POST /api/oportunidades");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OportunidadResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/oportunidades");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadResponseDTO> findById(@PathVariable Long id) {
        log.info("Petición HTTP: GET /api/oportunidades/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunidadResponseDTO> update(@PathVariable Long id, @RequestBody OportunidadUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/oportunidades/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Petición HTTP: DELETE /api/oportunidades/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}