package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTablets;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaCarritoTabletsRepository extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{
    
}
