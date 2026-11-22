package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class ContactoUpdateDTO {
    private String nombre;
    private Long organizacionId; // Solo el ID de la relación
    private String cargo;
    private String area;
    private String correo;
    private String telefono;
    private String medioPreferente;
    private String estado;
    private String fechaUltimoContacto;
    private String observacion;
}