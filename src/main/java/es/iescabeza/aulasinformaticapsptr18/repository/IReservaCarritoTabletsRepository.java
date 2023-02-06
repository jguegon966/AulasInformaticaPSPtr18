package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTablets;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA de ReservaCarritoTablets
 */
public interface IReservaCarritoTabletsRepository extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{
    
}
