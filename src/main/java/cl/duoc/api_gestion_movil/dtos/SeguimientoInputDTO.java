package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class SeguimientoInputDTO {
    private Long oportunidadId; // FK requerida
    private Long contactoId;    // FK opcional
    private String usuarioEmail;
    private String tipoGestion;
    private String propuesta;
    private String respuestaCliente;
    private String proximaAccion;
    private String fechaGestion;
    private String fechaProximaAccion;
    private String observacion;
}