package cl.trabajo4;

import java.util.ArrayList;

public interface IAsientos {

    void disponibles(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList);

    void recaudar(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList);

    void reservar(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList,
                  int opcion, int numeral);

}
