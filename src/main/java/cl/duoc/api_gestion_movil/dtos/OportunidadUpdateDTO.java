package cl.duoc.api_gestion_movil.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class OportunidadUpdateDTO {
    private String titulo;
    private String descripcion;
    private BigDecimal montoEstimado;
    private String etapaVenta; // Ej: PROSPECTO, NEGOCIACION, CERRADO_GANADO
    private Integer probabilidadExito; // Porcentaje (0-100)
    private LocalDate fechaCierreEsperada;
    private Long contactoId;

    // Getters y Setters
}