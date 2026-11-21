package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    private String tipoOrganizacion;
    private String rubro;
    private String comuna;
    private String region;
    private String website;
    private String audienciaObjetivo;

    @Column(columnDefinition = "TEXT")
    private String observacion;
}