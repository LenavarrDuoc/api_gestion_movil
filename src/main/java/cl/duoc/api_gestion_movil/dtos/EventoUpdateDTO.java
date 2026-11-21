package cl.duoc.api_gestion_movil.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventoUpdateDTO {
    private String titulo;
    private String descripcion;
    private String ubicacion; // Link de reunión o dirección física
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado; // Ej: PENDIENTE, COMPLETADO, CANCELADO

    // Getters y Setters
}