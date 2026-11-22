package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @Column(name = "id", length = 36)
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "tipo_evento", length = 100)
    private String tipoEvento;

    @Column(name = "fecha", length = 50)
    private String fecha;

    @Column(name = "hora", length = 20)
    private String hora;

    @Column(name = "region")
    private String region;

    @Column(name = "comuna")
    private String comuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @Column(name = "organizacion_nombre")
    private String organizacionNombre;

    @Column(name = "publico_esperado")
    private Integer publicoEsperado;

    @Column(name = "condiciones_participacion", length = 500)
    private String condicionesParticipacion;

    @Column(name = "ruta_foto_evidencia", length = 1000)
    private String rutaFotoEvidencia;
}