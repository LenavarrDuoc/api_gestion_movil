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
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private Long fecNac;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol = RolUsuario.CLIENTE;

    @Column(length = 1000)
    private String fotoUri;
}