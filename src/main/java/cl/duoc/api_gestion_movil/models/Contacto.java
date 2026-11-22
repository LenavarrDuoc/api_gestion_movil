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
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "organizacion_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_contacto_organizacion",
                    foreignKeyDefinition = "FOREIGN KEY (organizacion_id) REFERENCES organizaciones(id) ON DELETE CASCADE"
            )
    )
    private Organizacion organizacion;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "area")
    private String area;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "medio_preferente")
    private String medioPreferente;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_ultimo_contacto")
    private String fechaUltimoContacto;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;
}