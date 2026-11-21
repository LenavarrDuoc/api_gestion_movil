package cl.duoc.api_gestion_movil.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SeguimientoUpdateDTO {
    private String tipoInteraccion; // Ej: LLAMADA, EMAIL, REUNION_PRESENCIAL
    private String notas;
    private LocalDateTime fechaInteraccion;
    private Long oportunidadId;
    private Long contactoId;

    // Getters y Setters
}