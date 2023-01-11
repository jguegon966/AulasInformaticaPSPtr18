package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_tablets")
public class CarritoTablets
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 3, nullable = false)
    private int numeroTablets;

    @Column(length = 1)
    private int planta;

    public CarritoTablets()
    {
        // Implementacion vacia
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroTablets() {
        return numeroTablets;
    }

    public void setNumeroTablets(int numeroTablets) {
        this.numeroTablets = numeroTablets;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

}
