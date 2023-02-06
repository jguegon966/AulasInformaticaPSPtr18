package es.iescabeza.aulasinformaticapsptr18.controller;

import es.iescabeza.aulasinformaticapsptr18.models.*;
import es.iescabeza.aulasinformaticapsptr18.repository.*;
import es.iescabeza.aulasinformaticapsptr18.service.AllReservasService;
import es.iescabeza.aulasinformaticapsptr18.utils.TotalReservas;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservas", produces = {"application/json"})
public class MyRestController
{

    List<ReservaAula> listaReservasAulas = new ArrayList<>();

    List<ReservaCarritoTablets> listaReservasCarritoTablets = new ArrayList<>();

    List<ReservaCarritoPcs> listaReservasCarritoPcs = new ArrayList<>();

    @Autowired
    private AllReservasService allReservasService;

    @Autowired
    private IAulaInformaticaRepository iAulaInformaticaRepository;

    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Autowired
    private IReservaAulaRepository iReservaAulaRepository;

    @Autowired
    private IReservaCarritoTabletsRepository iReservaCarritoTabletsRepository;

    @Autowired
    private ICarritoTabletsRepository iCarritoTabletsRepository;

    @Autowired
    private IReservaCarritoPcsRepository iReservaCarritoPcsRepository;

    @Autowired
    private ICarritoPcRepository iCarritoPcRepository;

    public MyRestController()
    {
        // Empty constructor because of Spring dependency
    }

    /**
     * Visualizacion de las reservas
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/allReservations")
    public ResponseEntity<TotalReservas> listaReservas()
    {

        TotalReservas totalReservas = new TotalReservas();

        List<ReservaAula> reservaAulas = allReservasService.listaReservaAula();
        List<ReservaCarritoPcs> reservaCarritoPcs = allReservasService.listaReservaCarritoPc();
        List<ReservaCarritoTablets> reservaCarritoTablets = allReservasService.listaReservaCarritoTablets();

        totalReservas.setReservasAulas(reservaAulas);
        totalReservas.setReservasCarritoPcs(reservaCarritoPcs);
        totalReservas.setReservasCarritoTablets(reservaCarritoTablets);

        return new ResponseEntity<TotalReservas>(totalReservas, HttpStatus.OK);

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
                                        @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                        @RequestParam(value = "idAula", required = true) final Long idAula,
                                        @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {



        Date d = new Date(fechaReservaAula * 1000);

        //Paso 1 instancias la reserva del aula ID
        ReservaAulaId reservaAulaId = new ReservaAulaId();

        reservaAulaId.setIdAula(idAula);
        reservaAulaId.setIdProfesor(idProfesor);
        reservaAulaId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar la reservaAula
        ReservaAula reservaAula = new ReservaAula();

        reservaAula.setReservaAulaId(reservaAulaId);
        reservaAula.setIdProfesor(profesor);

        listaReservasAulas.add(reservaAula);

        sesion.setAttribute("reservaAula", listaReservasAulas);

        //this.iReservaAulaRepository.saveAndFlush(reservaAula);

        return new ResponseEntity<String>("Reserva de Aula guardada en sesion correctamente", HttpStatus.OK);

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
                                           @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                           @RequestParam(value = "idCarritoTablets", required = true) final Long idCarritoTablets,
                                           @RequestParam(value = "ubicacionPrestamoTablets", required = false) final String ubicacionPrestamoTablets,
                                           @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        Date d = new Date(fechaReservaAula * 1000);



        //Paso 1 instancias la reserva del aula ID

        ReservaCarritoTabletsId reservaCarritoTabletsId = new ReservaCarritoTabletsId();

        reservaCarritoTabletsId.setIdCarritoTablets(idCarritoTablets);
        reservaCarritoTabletsId.setIdProfesor(idProfesor);
        reservaCarritoTabletsId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar los carritosTablest

        CarritoTablets carritoTablets = new CarritoTablets();
        Optional<CarritoTablets> optionalCarritoTablets = iCarritoTabletsRepository.findById(idCarritoTablets);

        carritoTablets.setId(optionalCarritoTablets.get().getId());
        carritoTablets.setNumeroTablets(optionalCarritoTablets.get().getNumeroTablets());
        carritoTablets.setPlanta(optionalCarritoTablets.get().getPlanta());


        //Paso 4 instanciar la reserva del carrito
        ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets();
        reservaCarritoTablets.setReservaCarritoTabletsId(reservaCarritoTabletsId);
        reservaCarritoTablets.setIdCarritoTablets(carritoTablets);
        reservaCarritoTablets.setIdProfesor(profesor);
        reservaCarritoTablets.setUbicacionPrestamo(ubicacionPrestamoTablets);

        //this.iReservaCarritoTabletsRepository.saveAndFlush(reservaCarritoTablets);

        listaReservasCarritoTablets.add(reservaCarritoTablets);

        sesion.setAttribute("reservaCarritoTablets", listaReservasCarritoTablets);

        return new ResponseEntity<String>("Reserva de carro de Tablets guardada en sesion correctamente", HttpStatus.OK);

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
                                       @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                       @RequestParam(value = "idCarritoPcs", required = true) final Long idCarritoPcs,
                                       @RequestParam(value = "ubicacionPrestamoPcs", required = false) final String ubicacionPrestamoPcs,
                                       @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        Date d = new Date(fechaReservaAula * 1000);

        //Paso 1 instancias la reserva del aula ID

        ReservaCarritoPcsId reservaCarritoPcsId = new ReservaCarritoPcsId();

        reservaCarritoPcsId.setIdCarritoPcs(idCarritoPcs);
        reservaCarritoPcsId.setIdProfesor(idProfesor);
        reservaCarritoPcsId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar los carritosTablest

        CarritoPc carritoPc = new CarritoPc();
        Optional<CarritoPc> optionalCarritoPc = iCarritoPcRepository.findById(idCarritoPcs);

        carritoPc.setId(optionalCarritoPc.get().getId());
        carritoPc.setNumeroPcs(optionalCarritoPc.get().getNumeroPcs());
        carritoPc.setPlanta(optionalCarritoPc.get().getPlanta());


        //Paso 4 instanciar la reserva del carrito
        ReservaCarritoPcs reservaCarritoPcs = new ReservaCarritoPcs();
        reservaCarritoPcs.setIdCarritoPcs(carritoPc);
        reservaCarritoPcs.setIdProfesor(profesor);
        reservaCarritoPcs.setUbicacionPrestamo(ubicacionPrestamoPcs);
        reservaCarritoPcs.setReservaCarrtitoPcsId(reservaCarritoPcsId);

        //this.iReservaCarritoPcsRepository.saveAndFlush(reservaCarritoPcs);

        listaReservasCarritoPcs.add(reservaCarritoPcs);

        sesion.setAttribute("reservasCarritoPcs", listaReservasCarritoPcs);

        return new ResponseEntity<String>("Reserva de carro de Pcs guardada en sesion correctamente", HttpStatus.OK);
    }

    /**
     * Confirmacion de la seleccion
     * @param sesion
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/confirmReservation")
    public ResponseEntity<?> confirmarReserva(HttpSession sesion)
    {

        if (sesion.getAttribute("reservaAula") != null)
        {
            this.iReservaAulaRepository.saveAllAndFlush(listaReservasAulas);
        }

        if (sesion.getAttribute("reservaCarritoTablets") != null)
        {
            this.iReservaCarritoTabletsRepository.saveAllAndFlush(listaReservasCarritoTablets);
        }

        if (sesion.getAttribute("reservasCarritoPcs") != null)
        {
            this.iReservaCarritoPcsRepository.saveAllAndFlush(listaReservasCarritoPcs);
        }

        sesion.invalidate();

        return new ResponseEntity<String>("Reservas realizadas correctamente", HttpStatus.OK);

    }

    // hacer 3 endpoints mas con cancelar carrito pc, tablets y aulas

    @RequestMapping(method = RequestMethod.POST, value = "/cancelReservation")
    public ResponseEntity<?> cancelarSesiones(HttpSession sesion)
    {

        sesion.invalidate();

        return new ResponseEntity<String>("Reservas almacenadas en sesion canceladas correctamente", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteReservaAula")
    public ResponseEntity<?> deleteReservaAula(HttpSession sesion,
                                        @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                        @RequestParam(value = "idAula", required = true) final Long idAula,
                                        @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        Date d = new Date(fechaReservaAula * 1000);

        //Paso 1 instancias la reserva del aula ID
        ReservaAulaId reservaAulaId = new ReservaAulaId();

        reservaAulaId.setIdAula(idAula);
        reservaAulaId.setIdProfesor(idProfesor);
        reservaAulaId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar la reservaAula
        ReservaAula reservaAula = new ReservaAula();

        reservaAula.setReservaAulaId(reservaAulaId);
        reservaAula.setIdProfesor(profesor);

        iReservaAulaRepository.delete(reservaAula);

        return new ResponseEntity<String>("Aula eliminada de la base de datos correctamente", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteReservaCarroTablets")
    public ResponseEntity<?> deleteReservaCarroTablets(HttpSession sesion,
                                           @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                           @RequestParam(value = "idCarritoTablets", required = true) final Long idCarritoTablets,
                                           @RequestParam(value = "ubicacionPrestamoTablets", required = false) final String ubicacionPrestamoTablets,
                                           @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        Date d = new Date(fechaReservaAula * 1000);

        //Paso 1 instancias la reserva del aula ID

        ReservaCarritoTabletsId reservaCarritoTabletsId = new ReservaCarritoTabletsId();

        reservaCarritoTabletsId.setIdCarritoTablets(idCarritoTablets);
        reservaCarritoTabletsId.setIdProfesor(idProfesor);
        reservaCarritoTabletsId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar los carritosTablest

        CarritoTablets carritoTablets = new CarritoTablets();
        Optional<CarritoTablets> optionalCarritoTablets = iCarritoTabletsRepository.findById(idCarritoTablets);

        carritoTablets.setId(optionalCarritoTablets.get().getId());
        carritoTablets.setNumeroTablets(optionalCarritoTablets.get().getNumeroTablets());
        carritoTablets.setPlanta(optionalCarritoTablets.get().getPlanta());


        //Paso 4 instanciar la reserva del carrito
        ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets();
        reservaCarritoTablets.setReservaCarritoTabletsId(reservaCarritoTabletsId);
        reservaCarritoTablets.setIdCarritoTablets(carritoTablets);
        reservaCarritoTablets.setIdProfesor(profesor);
        reservaCarritoTablets.setUbicacionPrestamo(ubicacionPrestamoTablets);

        this.iReservaCarritoTabletsRepository.delete(reservaCarritoTablets);

        return new ResponseEntity<String>("Reserva de carro eliminada de la base de datos correctamente", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteReservaCarroPcs")
    public ResponseEntity<?> deleteReservaCarroPcs(HttpSession sesion,
                                       @RequestParam(value = "idProfesor", required = true) final Long idProfesor,
                                       @RequestParam(value = "idCarritoPcs", required = true) final Long idCarritoPcs,
                                       @RequestParam(value = "ubicacionPrestamoPcs", required = false) final String ubicacionPrestamoPcs,
                                       @RequestParam(value = "fechaReservaAula", required = true) final Long fechaReservaAula)
    {

        Date d = new Date(fechaReservaAula * 1000);

        //Paso 1 instancias la reserva del aula ID

        ReservaCarritoPcsId reservaCarritoPcsId = new ReservaCarritoPcsId();

        reservaCarritoPcsId.setIdCarritoPcs(idCarritoPcs);
        reservaCarritoPcsId.setIdProfesor(idProfesor);
        reservaCarritoPcsId.setFecha(d);

        //Paso 2 instanciar el profesor buscando por su id en su repositorio
        Profesor profesor = new Profesor();

        Optional<Profesor> optionalProfesor = iProfesorRepository.findById(idProfesor);

        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        //Paso 3 instanciar los carritosTablest

        CarritoPc carritoPc = new CarritoPc();
        Optional<CarritoPc> optionalCarritoPc = iCarritoPcRepository.findById(idCarritoPcs);

        carritoPc.setId(optionalCarritoPc.get().getId());
        carritoPc.setNumeroPcs(optionalCarritoPc.get().getNumeroPcs());
        carritoPc.setPlanta(optionalCarritoPc.get().getPlanta());


        //Paso 4 instanciar la reserva del carrito
        ReservaCarritoPcs reservaCarritoPcs = new ReservaCarritoPcs();
        reservaCarritoPcs.setIdCarritoPcs(carritoPc);
        reservaCarritoPcs.setIdProfesor(profesor);
        reservaCarritoPcs.setUbicacionPrestamo(ubicacionPrestamoPcs);
        reservaCarritoPcs.setReservaCarrtitoPcsId(reservaCarritoPcsId);

        this.iReservaCarritoPcsRepository.delete(reservaCarritoPcs);

        return new ResponseEntity<String>("Reserva de carro de Pcs eliminada de la base de datos correctamente", HttpStatus.OK);
    }

    //Y documenta algo que luego se te olvida

}