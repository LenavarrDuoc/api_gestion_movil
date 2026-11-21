package cl.duoc.api_gestion_movil.repositories;

import cl.duoc.api_gestion_movil.models.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {
}