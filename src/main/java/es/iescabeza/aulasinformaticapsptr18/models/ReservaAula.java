package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reserva_aula")
public class ReservaAula
{

    @EmbeddedId
    private ReservaAulaId reservaAulaId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    public ReservaAula()
    {
        // Implementacion vacia
    }

    public ReservaAulaId getReservaAulaId() {
        return reservaAulaId;
    }

    public void setReservaAulaId(ReservaAulaId reservaAulaId) {
        this.reservaAulaId = reservaAulaId;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

}
