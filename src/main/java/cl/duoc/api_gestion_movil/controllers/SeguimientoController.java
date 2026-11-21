package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.SeguimientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/seguimientos")
@RequiredArgsConstructor
public class SeguimientoController {
    private final SeguimientoService service;

    @PostMapping
    public ResponseEntity<SeguimientoResponseDTO> create(@RequestBody SeguimientoInputDTO input) {
        log.info("Petición HTTP: POST /api/seguimientos");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SeguimientoResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/seguimientos");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoResponseDTO> findById(@PathVariable Long id) {
        log.info("Petición HTTP: GET /api/seguimientos/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoResponseDTO> update(@PathVariable Long id, @RequestBody SeguimientoUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/seguimientos/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Petición HTTP: DELETE /api/seguimientos/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}