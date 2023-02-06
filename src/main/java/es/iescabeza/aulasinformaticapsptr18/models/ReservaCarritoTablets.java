package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.*;

/**
 * Clase entidad ReservaCarritoTablets
 */
@Entity
@Table(name = "reserva_carrito_tablets")
public class ReservaCarritoTablets
{

    //Attributes

    //Referencia a clase que genera tabla ReservaCarritoTabletsId
    @EmbeddedId
    private ReservaCarritoTabletsId reservaCarritoTabletsId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_tablets")
    @MapsId("idCarritoTablets")
    private CarritoTablets idCarritoTablets;

    @Column
    private String ubicacionPrestamo;

    /**
     * Constructor por defecto
     */
    public ReservaCarritoTablets()
    {
        // Implementacion vacia
    }

    //Getters and Setters

    public ReservaCarritoTabletsId getReservaCarritoTabletsId()
    {
        return reservaCarritoTabletsId;
    }

    public void setReservaCarritoTabletsId(ReservaCarritoTabletsId reservaCarritoTabletsId)
    {
        this.reservaCarritoTabletsId = reservaCarritoTabletsId;
    }

    public Profesor getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public CarritoTablets getIdCarritoTablets()
    {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(CarritoTablets idCarritoTablets)
    {
        this.idCarritoTablets = idCarritoTablets;
    }

    public String getUbicacionPrestamo()
    {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo)
    {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
