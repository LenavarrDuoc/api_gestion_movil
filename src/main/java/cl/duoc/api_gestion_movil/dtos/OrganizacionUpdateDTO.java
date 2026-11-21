package cl.duoc.api_gestion_movil.dtos;

import lombok.Data;

@Data
public class OrganizacionUpdateDTO {
    private String nombre;
    private String tipoOrganizacion;
    private String rubro;
    private String comuna;
    private String region;
    private String website;
    private String audienciaObjetivo;
    private String observacion;
}