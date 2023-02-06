package es.iescabeza.aulasinformaticapsptr18.utils;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaAula;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoPcs;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTablets;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase TotalReservas encargada de coger en forma de listas todas las reservas, tanto de carritos, como de aula
 */
public class TotalReservas
{

    //Attributes en forma de listas
    private List<ReservaAula> reservasAulas;
    private List<ReservaCarritoPcs> reservasCarritoPcs;
    private List<ReservaCarritoTablets> reservasCarritoTablets;

    /**
     * Constructor al que se le pasan los parametros
     * @param reservasAulas lista de reservas de aulas
     * @param reservasCarritoPcs lista de reservas de carritos de pcs
     * @param reservasCarritoAulas lista de reservas de carritos de tablets
     */
    public TotalReservas(List<ReservaAula> reservasAulas, List<ReservaCarritoPcs> reservasCarritoPcs, List<ReservaCarritoTablets> reservasCarritoAulas)
    {
        this.reservasAulas = reservasAulas;
        this.reservasCarritoPcs = reservasCarritoPcs;
        this.reservasCarritoTablets = reservasCarritoAulas;
    }

    /**
     * Constructor por defecto
     */
    public TotalReservas()
    {
        this.reservasAulas = new ArrayList<>();
        this.reservasCarritoPcs = new ArrayList<>();
        this.reservasCarritoTablets = new ArrayList<>();
    }

    //Getters and setters

    public List<ReservaAula> getReservasAulas()
    {
        return reservasAulas;
    }

    public void setReservasAulas(List<ReservaAula> reservasAulas)
    {
        this.reservasAulas = reservasAulas;
    }

    public List<ReservaCarritoPcs> getReservasCarritoPcs()
    {
        return reservasCarritoPcs;
    }

    public void setReservasCarritoPcs(List<ReservaCarritoPcs> reservasCarritoPcs)
    {
        this.reservasCarritoPcs = reservasCarritoPcs;
    }

    public List<ReservaCarritoTablets> getReservasCarritoTablets()
    {
        return reservasCarritoTablets;
    }

    public void setReservasCarritoTablets(List<ReservaCarritoTablets> reservasCarritoTablets)
    {
        this.reservasCarritoTablets = reservasCarritoTablets;
    }

    /**
     * Generated ToString
     * @return devuelve un String con las listas de las reservas
     */
    @Override
    public String toString()
    {
        return "TotalReservas{" +
                "reservasAulas=" + reservasAulas +
                ", reservasCarritoPcs=" + reservasCarritoPcs +
                ", reservasCarritoAulas=" + reservasCarritoTablets +
                '}';
    }
}
