package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seguimientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "oportunidad_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_seguimiento_oportunidad",
                    foreignKeyDefinition = "FOREIGN KEY (oportunidad_id) REFERENCES oportunidades(id) ON DELETE CASCADE"
            )
    )
    private Oportunidad oportunidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "contacto_id",
            foreignKey = @ForeignKey(
                    name = "fk_seguimiento_contacto",
                    foreignKeyDefinition = "FOREIGN KEY (contacto_id) REFERENCES contactos(id) ON DELETE SET NULL"
            )
    )
    private Contacto contacto;

    @Column(name = "usuario_email")
    private String usuarioEmail;

    @Column(name = "tipo_gestion")
    private String tipoGestion;

    @Column(name = "propuesta", columnDefinition = "TEXT")
    private String propuesta;

    @Column(name = "respuesta_cliente", columnDefinition = "TEXT")
    private String respuestaCliente;

    @Column(name = "proxima_accion")
    private String proximaAccion;

    @Column(name = "fecha_gestion", length = 50)
    private String fechaGestion;

    @Column(name = "fecha_proxima_accion", length = 50)
    private String fechaProximaAccion;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;
}