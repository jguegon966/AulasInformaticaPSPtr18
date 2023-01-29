package es.iescabeza.aulasinformaticapsptr18.controller;

import es.iescabeza.aulasinformaticapsptr18.models.CarritoPc;
import es.iescabeza.aulasinformaticapsptr18.repository.ICarritoPcRepository;
import es.iescabeza.aulasinformaticapsptr18.service.CarritoPcService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reservas", produces = {"application/json"})
public class MyRestController
{

    @Autowired
    CarritoPcService carritoPcService;

    public MyRestController()
    {
        // Empty constructor because of Spring dependency
    }

    /**
     * Visualizacion de las reservas
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/allReservations")
    public ResponseEntity<List<CarritoPc>> listaReservas()
    {

        List<CarritoPc> carrosPc = carritoPcService.listaCarritoPc();
        return new ResponseEntity<List<CarritoPc>>(carrosPc, HttpStatus.OK);

    }

    /**
     * Seleccion de aulas
     * @param sesion
     * @param idProfesor
     * @param idAula
     * @param fechaReservaAula
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/selectAula")
    public ResponseEntity<?> selectAula(HttpSession sesion,
                                        @RequestParam(value = "idProfesor", required = true) final Integer idProfesor,
                                        @RequestParam(value = "idAula", required = true) final Integer idAula,
                                        @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        return null;

    }

    /**
     * Seleccion de carritos Tablets
     * @param sesion
     * @param idProfesor
     * @param idCarritoTablets
     * @param ubicacionPrestamoTablets
     * @param fechaReservaAula
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/selectTablets")
    public ResponseEntity<?> selectTablets(HttpSession sesion,
                                           @RequestParam(value = "idProfesor", required = true) final Integer idProfesor,
                                           @RequestParam(value = "idCarritoTablets", required = true) final Integer idCarritoTablets,
                                           @RequestParam(value = "ubicacionPrestamoTablets", required = false) final String ubicacionPrestamoTablets,
                                           @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        return null;

    }

    /**
     * Seleccion de carritos PCs
     * @param sesion
     * @param idProfesor
     * @param idCarritoPcs
     * @param ubicacionPrestamoPcs
     * @param fechaReservaAula
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/selectPcs")
    public ResponseEntity<?> selectPcs(HttpSession sesion,
                                       @RequestParam(value = "idProfesor", required = true) final Integer idProfesor,
                                       @RequestParam(value = "idCarritoPcs", required = true) final Integer idCarritoPcs,
                                       @RequestParam(value = "ubicacionPrestamoPcs", required = false) final String ubicacionPrestamoPcs,
                                       @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        return null;

    }

    /**
     * Confirmacion de la seleccion
     * @param sesion
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/confirmReservation")
    public ResponseEntity<?> confirmarReserva(HttpSession sesion,
                                              @RequestParam(value = "confirmacion", required = true) final String confirmacion)
    {

        return null;

    }

    // hacer 3 endpoints mas con cancelar carrito pc, tablets y aulas

}


