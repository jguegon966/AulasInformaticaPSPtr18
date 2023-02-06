package es.iescabeza.aulasinformaticapsptr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase entidad Aula_informatica
 */
@Entity
@Table(name = "aula_informatica")
public class AulaInformatica
{

    //Attributes

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 3, nullable = false)
    private int numeroAula;

    @Column(length = 1, nullable = false)
    private int planta;

    /**
     * Constructor por defecto
     */
    public AulaInformatica()
    {
        // Implementacion vacia
    }

    //Getters and Setters

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getNumeroAula()
    {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula)
    {
        this.numeroAula = numeroAula;
    }

    public int getPlanta()
    {
        return planta;
    }

    public void setPlanta(int planta)
    {
        this.planta = planta;
    }

}
