package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class SeguimientoResponseDTO {
    private Long id;
    private Long oportunidadId;
    private Long contactoId;
    private String usuarioEmail;
    private String tipoGestion;
    private String propuesta;
    private String respuestaCliente;
    private String proximaAccion;
    private String fechaGestion;
    private String fechaProximaAccion;
    private String observacion;
}