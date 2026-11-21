package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class OrganizacionUpdateDTO {
    private String nombre;
    private String direccion;
    private String industria;
    private String sitioWeb;
    private String telefonoPrincipal;

    // Getters y Setters
}