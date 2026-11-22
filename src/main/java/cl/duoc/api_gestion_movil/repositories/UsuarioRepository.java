package cl.duoc.api_gestion_movil.repositories;

import cl.duoc.api_gestion_movil.models.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByEmail(@NotBlank(message = "El email es obligatorio") @Email(message = "Debe tener un formato de correo válido") String email);
}