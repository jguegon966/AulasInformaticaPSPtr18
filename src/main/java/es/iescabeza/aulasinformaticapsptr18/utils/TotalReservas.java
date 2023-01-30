package es.iescabeza.aulasinformaticapsptr18.utils;

import es.iescabeza.aulasinformaticapsptr18.models.ReservaAula;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoPcs;
import es.iescabeza.aulasinformaticapsptr18.models.ReservaCarritoTablets;

import java.util.ArrayList;
import java.util.List;

public class TotalReservas
{

    private List<ReservaAula> reservasAulas;
    private List<ReservaCarritoPcs> reservasCarritoPcs;
    private List<ReservaCarritoTablets> reservasCarritoTablets;

    public TotalReservas(List<ReservaAula> reservasAulas, List<ReservaCarritoPcs> reservasCarritoPcs, List<ReservaCarritoTablets> reservasCarritoAulas) {
        this.reservasAulas = reservasAulas;
        this.reservasCarritoPcs = reservasCarritoPcs;
        this.reservasCarritoTablets = reservasCarritoAulas;
    }

    public TotalReservas() {
        this.reservasAulas = new ArrayList<>();
        this.reservasCarritoPcs = new ArrayList<>();
        this.reservasCarritoTablets = new ArrayList<>();
    }

    public List<ReservaAula> getReservasAulas() {
        return reservasAulas;
    }

    public void setReservasAulas(List<ReservaAula> reservasAulas) {
        this.reservasAulas = reservasAulas;
    }

    public List<ReservaCarritoPcs> getReservasCarritoPcs() {
        return reservasCarritoPcs;
    }

    public void setReservasCarritoPcs(List<ReservaCarritoPcs> reservasCarritoPcs) {
        this.reservasCarritoPcs = reservasCarritoPcs;
    }

    public List<ReservaCarritoTablets> getReservasCarritoTablets() {
        return reservasCarritoTablets;
    }

    public void setReservasCarritoTablets(List<ReservaCarritoTablets> reservasCarritoTablets) {
        this.reservasCarritoTablets = reservasCarritoTablets;
    }

    @Override
    public String toString() {
        return "TotalReservas{" +
                "reservasAulas=" + reservasAulas +
                ", reservasCarritoPcs=" + reservasCarritoPcs +
                ", reservasCarritoAulas=" + reservasCarritoTablets +
                '}';
    }
}
