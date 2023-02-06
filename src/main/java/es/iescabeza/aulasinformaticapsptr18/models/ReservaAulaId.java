package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase embedable ReservaAulaId
 */
@Embeddable
public class ReservaAulaId implements Serializable
{

    //Attributes

    private static final long serialVersionUID = 143517546487453214L;

    private Long idProfesor;

    private Long idAula;

    private Date fecha;

    /**
     * Constructor por defecto
     */
    public ReservaAulaId()
    {
        // Implementacion vacia
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

    public Long getIdAula()
    {
        return idAula;
    }

    public void setIdAula(Long idAula)
    {
        this.idAula = idAula;
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
