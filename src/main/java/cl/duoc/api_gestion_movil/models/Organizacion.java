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
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_organizacion")
    private String tipoOrganizacion;

    @Column(name = "rubro")
    private String rubro;

    @Column(name = "comuna")
    private String comuna;

    @Column(name = "region")
    private String region;

    @Column(name = "website")
    private String website;

    @Column(name = "audiencia_objetivo")
    private String audienciaObjetivo;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;
}