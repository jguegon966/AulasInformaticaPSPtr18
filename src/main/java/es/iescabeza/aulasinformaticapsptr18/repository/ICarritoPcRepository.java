package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.CarritoPc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA de CarritoPc
 */
public interface ICarritoPcRepository extends JpaRepository<CarritoPc, Long>
{

}
