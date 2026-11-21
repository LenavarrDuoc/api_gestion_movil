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
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String titulo;
    private String tipoEvento;
    private String fecha;
    private String hora;
    private String region;
    private String comuna;

    // Relacionado a Organización (Corregido a ManyToOne para consistencia, o puedes dejarlo como Long directo si lo prefieres)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    private String organizacionNombre;
    private Integer publicoEsperado;
    private String condicionesParticipacion;

    @Column(length = 1000)
    private String rutaFotoEvidencia;
}