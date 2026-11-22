package cl.duoc.api_gestion_movil.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @Column(name = "id", length = 36)
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(name = "p_nombre")
    private String pNombre;

    @Column(name = "s_nombre")
    private String sNombre;

    @Column(name = "p_apellido")
    private String pApellido;

    @Column(name = "s_apellido")
    private String sApellido;

    @Column(name = "fec_nac")
    private Long fecNac;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", length = 50, nullable = false)
    @Builder.Default
    private RolUsuario rol = RolUsuario.CLIENTE;

    @Column(name = "foto_uri", length = 1000)
    private String fotoUri;
}