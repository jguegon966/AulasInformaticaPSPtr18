package es.iescabeza.aulasinformaticapsptr18.service;

import es.iescabeza.aulasinformaticapsptr18.models.CarritoPc;
import es.iescabeza.aulasinformaticapsptr18.repository.ICarritoPcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarritoPcService
{
    @Autowired
    private ICarritoPcRepository iCarritoPcRepository;

    public List<CarritoPc> listaCarritoPc()
    {
        return iCarritoPcRepository.findAll();
    }
}
