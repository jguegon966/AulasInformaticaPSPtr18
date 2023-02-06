package es.iescabeza.aulasinformaticapsptr18.service;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaAula;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoPcs;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTablets;
import es.iescabeza.aulasinformaticapsptr18.repository.IReservaAulaRepository;
import es.iescabeza.aulasinformaticapsptr18.repository.IReservaCarritoPcsRepository;
import es.iescabeza.aulasinformaticapsptr18.repository.IReservaCarritoTabletsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase encargada de llamar a los repositorios de reservas y los busca en la base de datos
 */
@Service
@Transactional
public class AllReservasService
{

    @Autowired
    private IReservaAulaRepository iReservaAulaRepository;

    @Autowired
    private IReservaCarritoPcsRepository iReservaCarritoPcsRepository;

    @Autowired
    private IReservaCarritoTabletsRepository iReservaCarritoTabletsRepository;

    public List<ReservaAula> listaReservaAula()
    {
        return iReservaAulaRepository.findAll();
    }

    public List<ReservaCarritoPcs> listaReservaCarritoPc()
    {
        return iReservaCarritoPcsRepository.findAll();
    }
    public List<ReservaCarritoTablets> listaReservaCarritoTablets()
    {
        return iReservaCarritoTabletsRepository.findAll();
    }

}
