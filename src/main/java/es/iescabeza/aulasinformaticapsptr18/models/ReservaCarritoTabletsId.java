package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase embedable ReservaCarritoTabletsId
 */
@Embeddable
public class ReservaCarritoTabletsId implements Serializable
{

    //Attributes

    private static final long serialVersionUID = -156123789941234788L;

    private Long idProfesor;

    private Long idCarritoTablets;

    private Date fecha;

    /**
     * Constructor por defecto
     */
    public ReservaCarritoTabletsId()
    {

    }

    //Getters and setters

    public Long getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoTablets()
    {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(Long idCarritoTablets)
    {
        this.idCarritoTablets = idCarritoTablets;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
}
