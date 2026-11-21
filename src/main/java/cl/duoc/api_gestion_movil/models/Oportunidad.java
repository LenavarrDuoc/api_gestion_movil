package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "oportunidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id", foreignKey = @ForeignKey(name = "fk_oportunidad_organizacion", foreignKeyDefinition = "FOREIGN KEY (organizacion_id) REFERENCES organizaciones(id) ON DELETE SET NULL"))
    private Organizacion organizacion;

    @Column(columnDefinition = "TEXT")
    private String observacion;
}