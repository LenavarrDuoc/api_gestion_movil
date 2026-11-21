package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.OrganizacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/organizaciones")
@RequiredArgsConstructor
public class OrganizacionController {
    private final OrganizacionService service;

    @PostMapping
    public ResponseEntity<OrganizacionResponseDTO> create(@RequestBody OrganizacionInputDTO input) {
        log.info("Petición HTTP: POST /api/organizaciones");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizacionResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/organizaciones");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizacionResponseDTO> findById(@PathVariable Long id) {
        log.info("Petición HTTP: GET /api/organizaciones/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizacionResponseDTO> update(@PathVariable Long id, @RequestBody OrganizacionUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/organizaciones/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Petición HTTP: DELETE /api/organizaciones/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}