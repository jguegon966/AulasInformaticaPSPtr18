package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaAula;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaAulaId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA de ReservaAula
 */
public interface IReservaAulaRepository extends JpaRepository<ReservaAula, ReservaAulaId>
{

}
