package cl.duoc.api_gestion_movil.repositories;

import cl.duoc.api_gestion_movil.models.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
}