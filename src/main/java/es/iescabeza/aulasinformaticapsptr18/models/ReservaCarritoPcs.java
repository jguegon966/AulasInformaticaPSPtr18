package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reserva_carrito_pcs")
public class ReservaCarritoPcs
{

    @EmbeddedId
    private ReservaCarritoPcsId reservaCarrtitoPcsId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPc idCarritoPcs;

    @Column(length = 50)
    private String ubicacionPrestamo;


    public ReservaCarritoPcs()
    {
        // Implementacion vacia
    }

    public ReservaCarritoPcsId getReservaCarrtitoPcsId() {
        return reservaCarrtitoPcsId;
    }

    public void setReservaCarrtitoPcsId(ReservaCarritoPcsId reservaCarrtitoPcsId) {
        this.reservaCarrtitoPcsId = reservaCarrtitoPcsId;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public CarritoPc getIdCarritoPcs() {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(CarritoPc idCarritoPcs) {
        this.idCarritoPcs = idCarritoPcs;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo) {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
