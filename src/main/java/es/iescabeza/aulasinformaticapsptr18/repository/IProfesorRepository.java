package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

}
