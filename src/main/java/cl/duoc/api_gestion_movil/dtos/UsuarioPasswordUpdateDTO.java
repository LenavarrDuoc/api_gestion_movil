package cl.duoc.api_gestion_movil.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioPasswordUpdateDTO {

    @NotBlank(message = "La contraseña es obligatoria y no puede estar vacía")
    private String password;

}