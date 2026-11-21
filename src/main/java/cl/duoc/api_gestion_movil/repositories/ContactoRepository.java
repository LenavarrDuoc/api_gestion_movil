package cl.duoc.api_gestion_movil.repositories;

import cl.duoc.api_gestion_movil.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}