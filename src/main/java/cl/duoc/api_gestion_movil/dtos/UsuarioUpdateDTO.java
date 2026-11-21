package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class UsuarioUpdateDTO {
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private Long fecNac;
    private String rol;
    private String fotoUri;
}