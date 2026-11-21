package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class ContactoUpdateDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cargo;
    private Long organizacionId;

    // Getters y Setters
}