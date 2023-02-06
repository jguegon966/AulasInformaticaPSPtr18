package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.*;

/**
 * Clase entidad ReservaAula
 */
@Entity
@Table(name = "reserva_aula")
public class ReservaAula
{

    //Attributes

    //referencia a la clase que genera tabla
    @EmbeddedId
    private ReservaAulaId reservaAulaId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    /**
     * Constructor por defecto
     */
    public ReservaAula()
    {
        // Implementacion vacia
    }

    //Getters and setters

    public ReservaAulaId getReservaAulaId()
    {
        return reservaAulaId;
    }

    public void setReservaAulaId(ReservaAulaId reservaAulaId)
    {
        this.reservaAulaId = reservaAulaId;
    }

    public Profesor getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor)
    {
        this.idProfesor = idProfesor;
    }

}
