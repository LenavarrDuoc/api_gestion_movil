package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contacto_organizacion", foreignKeyDefinition = "FOREIGN KEY (organizacion_id) REFERENCES organizaciones(id) ON DELETE CASCADE"))
    private Organizacion organizacion;

    private String cargo;
    private String area;
    private String correo;
    private String telefono;
    private String medioPreferente;
    private String estado;
    private String fechaUltimoContacto;

    @Column(columnDefinition = "TEXT")
    private String observacion;
}