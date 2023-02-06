package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoPcs;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoPcsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA de ReservaCarritoPcs
 */
public interface IReservaCarritoPcsRepository extends JpaRepository<ReservaCarritoPcs, ReservaCarritoPcsId>
{

}
