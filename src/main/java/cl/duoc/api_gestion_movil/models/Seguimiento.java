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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oportunidad_id", nullable = false, foreignKey = @ForeignKey(name = "fk_seguimiento_oportunidad", foreignKeyDefinition = "FOREIGN KEY (oportunidad_id) REFERENCES oportunidades(id) ON DELETE CASCADE"))
    private Oportunidad oportunidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contacto_id", foreignKey = @ForeignKey(name = "fk_seguimiento_contacto", foreignKeyDefinition = "FOREIGN KEY (contacto_id) REFERENCES contactos(id) ON DELETE SET NULL"))
    private Contacto contacto;

    private String usuarioEmail;
    private String tipoGestion;

    @Column(columnDefinition = "TEXT")
    private String propuesta;

    @Column(columnDefinition = "TEXT")
    private String respuestaCliente;

    private String proximaAccion;
    private String fechaGestion;
    private String fechaProximaAccion;

    @Column(columnDefinition = "TEXT")
    private String observacion;
}