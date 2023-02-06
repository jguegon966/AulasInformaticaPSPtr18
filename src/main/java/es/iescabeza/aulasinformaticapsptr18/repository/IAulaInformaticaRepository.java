package es.iescabeza.aulasinformaticapsptr18.repository;

import es.iescabeza.aulasinformaticapsptr18.models.AulaInformatica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA de AulaInformatica
 */
public interface IAulaInformaticaRepository extends JpaRepository<AulaInformatica, Long>
{

}
