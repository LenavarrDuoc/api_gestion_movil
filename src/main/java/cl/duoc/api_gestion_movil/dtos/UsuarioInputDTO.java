package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class UsuarioInputDTO {
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private Long fecNac;
    private String email;
    private String password;
    private String rol; // ADMIN, SUPERVISOR, EJECUTIVO, CLIENTE
    private String fotoUri;
}