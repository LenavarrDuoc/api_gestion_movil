package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.EventoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService service;

    @PostMapping
    public ResponseEntity<EventoResponseDTO> create(@RequestBody EventoInputDTO input) {
        log.info("Petición HTTP: POST /api/eventos");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/eventos");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> findById(@PathVariable String id) {
        log.info("Petición HTTP: GET /api/eventos/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable String id, @RequestBody EventoUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/eventos/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Petición HTTP: DELETE /api/eventos/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build(); // HttpStatus.NO_CONTENT (204)
    }
}