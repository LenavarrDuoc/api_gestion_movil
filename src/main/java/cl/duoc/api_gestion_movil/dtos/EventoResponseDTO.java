package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class EventoResponseDTO {
    private String id;
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