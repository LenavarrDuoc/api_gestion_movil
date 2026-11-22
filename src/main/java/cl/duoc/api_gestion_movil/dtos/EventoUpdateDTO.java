package cl.duoc.api_gestion_movil.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventoUpdateDTO {
    private String titulo;
    private String tipoEvento;
    private String fecha;
    private String hora;
    private String region;
    private String comuna;
    private Long organizacionId;
    private String organizacionNombre;
    private Integer publicoEsperado;
    private String condicionesParticipacion;
    private String rutaFotoEvidencia;
}