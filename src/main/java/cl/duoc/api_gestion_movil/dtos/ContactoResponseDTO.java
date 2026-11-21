package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class ContactoResponseDTO {
    private Long id;
    private String nombre;
    private Long organizacionId;
    private String cargo;
    private String area;
    private String correo;
    private String telefono;
    private String medioPreferente;
    private String estado;
    private String fechaUltimoContacto;
    private String observacion;
}