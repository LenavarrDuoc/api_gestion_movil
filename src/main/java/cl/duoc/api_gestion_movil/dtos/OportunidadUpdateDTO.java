package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OportunidadUpdateDTO {
    private String titulo;
    private String descripcion;
    private BigDecimal montoEstimado;
    private String etapaVenta;
    private Integer probabilidadExito;
    private LocalDate fechaCierreEsperada;
    private Long contactoId;
    private Long organizacionId; // <-- Esto soluciona el error del Mapper
}