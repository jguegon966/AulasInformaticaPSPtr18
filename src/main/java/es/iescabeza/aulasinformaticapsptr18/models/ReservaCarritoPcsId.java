package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase embedable ReservaCarritoPcsId
 */
@Embeddable
public class ReservaCarritoPcsId implements Serializable
{

    //Attributes

    private static final long serialVersionUID = -1234567895231235649L;

    private Long idProfesor;

    private Long idCarritoPcs;

    private Date fecha;

    /**
     * Constrcutor por defecto
     */
    public ReservaCarritoPcsId()
    {

    }

    //Attributes

    public Long getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoPcs()
    {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(Long idCarritoPcs)
    {
        this.idCarritoPcs = idCarritoPcs;
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
