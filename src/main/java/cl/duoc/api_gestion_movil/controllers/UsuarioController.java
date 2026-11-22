package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.*;
import cl.duoc.api_gestion_movil.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioInputDTO input) {
        log.info("Petición HTTP: POST /api/usuarios");
        return new ResponseEntity<>(service.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        log.info("Petición HTTP: GET /api/usuarios");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable String id) {
        log.info("Petición HTTP: GET /api/usuarios/{}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable String id, @RequestBody UsuarioUpdateDTO input) {
        log.info("Petición HTTP: PUT /api/usuarios/{}", id);
        return ResponseEntity.ok(service.update(id, input));
    }

    // Agrega este méto.do y los imports necesarios dentro de tu UsuarioController existente

    @PatchMapping("/{id}/password")
    public ResponseEntity<UsuarioResponseDTO> updatePassword(
            @PathVariable String id,
            @Valid @RequestBody UsuarioPasswordUpdateDTO input) {

        log.info("Petición HTTP: PATCH /api/usuarios/{}/password", id);
        return ResponseEntity.ok(service.updatePassword(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Petición HTTP: DELETE /api/usuarios/{}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}