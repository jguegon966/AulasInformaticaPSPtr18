package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reserva_aula")
public class ReservaAula
{

    @Id
    @Column(length = 10, nullable = false)
    private Long idProfesor;

    @Id
    @Column(length = 10, nullable = false)
    private Long idAula;

    @Id
    @Column(nullable = false)
    private Date fecha;

    public ReservaAula()
    {
        // Implementacion vacia
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
