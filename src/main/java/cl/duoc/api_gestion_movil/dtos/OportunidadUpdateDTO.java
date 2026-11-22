package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OportunidadUpdateDTO {
    private String nombre;
    private String tipoOportunidad;
    private String descripcion;
    private String fuenteInformacion;
    private String fechaDeteccion;
    private String responsableInterno;
    private String prioridad;
    private String potencialEstimado;
    private String estado;
    private String fechaUltimaActualizacion;
    private Long organizacionId; // FK
    private String observacion;
}