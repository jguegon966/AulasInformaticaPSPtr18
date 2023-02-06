package es.iescabeza.aulasinformaticapsptr18.service;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaAula;
import es.iescabeza.aulasinformaticapsptr18.repository.IReservaAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase encargada de buscar las reservas de aulas
 */
@Service
@Transactional
public class ReservaAulaService
{

    @Autowired
    private IReservaAulaRepository iReservaAulaRepository;

    public List<ReservaAula> listaReservaAula()
    {
        return iReservaAulaRepository.findAll();
    }

}
