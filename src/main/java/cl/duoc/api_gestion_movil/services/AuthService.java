package cl.duoc.api_gestion_movil.services;

import cl.duoc.api_gestion_movil.dtos.LoginRequestDTO;
import cl.duoc.api_gestion_movil.dtos.UsuarioResponseDTO;
import cl.duoc.api_gestion_movil.mappers.UsuarioMapper;
import cl.duoc.api_gestion_movil.models.Usuario;
import cl.duoc.api_gestion_movil.repositories.UsuarioRepository;
import cl.duoc.api_gestion_movil.utils.LogUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO login(LoginRequestDTO request) {
        log.info("Intento de login para email: {}", LogUtil.maskEmail(request.getEmail()));

        // 1. Buscar al usuario por correo
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas")); // Por seguridad, no decimos si falló el correo o la clave

        // 2. Verificar la contraseña
        // IMPORTANTE: En producción esto debe usar passwordEncoder.matches(request.getPassword(), usuario.getPassword())
        if (!usuario.getPassword().equals(request.getPassword())) {
            log.warn("Login fallido para email: {} - Contraseña incorrecta", LogUtil.maskEmail(request.getEmail()));
            throw new RuntimeException("Credenciales inválidas");
        }

        log.info("Login exitoso para email: {}", LogUtil.maskEmail(request.getEmail()));

        // 3. Retornar los datos del usuario sin exponer la contraseña
        return usuarioMapper.toResponseDTO(usuario);
    }
}