package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA de Profesor
 */
public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

}
