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
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_oportunidad")
    private String tipoOportunidad;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "fuente_informacion")
    private String fuenteInformacion;

    @Column(name = "fecha_deteccion", length = 50)
    private String fechaDeteccion;

    @Column(name = "responsable_interno")
    private String responsableInterno;

    @Column(name = "prioridad", length = 50)
    private String prioridad;

    @Column(name = "potencial_estimado", length = 100)
    private String potencialEstimado;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "fecha_ultima_actualizacion", length = 50)
    private String fechaUltimaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "organizacion_id",
            foreignKey = @ForeignKey(
                    name = "fk_oportunidad_organizacion",
                    foreignKeyDefinition = "FOREIGN KEY (organizacion_id) REFERENCES organizaciones(id) ON DELETE SET NULL"
            )
    )
    private Organizacion organizacion;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;
}