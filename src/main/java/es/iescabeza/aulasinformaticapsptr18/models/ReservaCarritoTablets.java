package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reserva_carrito_tablets")
public class ReservaCarritoTablets
{

    @Id
    @Column(length = 10)
    private Long idProfesor;

    @Id
    @Column(length = 10)
    private Long idCarritoTablets;

    @Column(length = 50)
    private String ubicacionPrestamo;

    @Id
    @Column(nullable = false)
    private Date fecha;

    public ReservaCarritoTablets()
    {
        // Implementacion vacia
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoTablets() {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(Long idCarritoTablets) {
        this.idCarritoTablets = idCarritoTablets;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo) {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
