package cl.duoc.api_gestion_movil.controllers;

import cl.duoc.api_gestion_movil.dtos.LoginRequestDTO;
import cl.duoc.api_gestion_movil.dtos.UsuarioResponseDTO;
import cl.duoc.api_gestion_movil.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        log.info("Petición HTTP: POST /api/auth/login");
        return ResponseEntity.ok(authService.login(request));
    }
}