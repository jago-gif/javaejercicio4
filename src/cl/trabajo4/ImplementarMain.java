package cl.trabajo4;

import java.util.ArrayList;
import java.util.Scanner;

public class ImplementarMain implements IImplementarMain {



    @Override
    public void disponibles(ArrayList<Palco> palcoList, ArrayList<Platea> plateaList, ArrayList<Galeria> galeriaList) {
        System.out.println("Estos son los asientos disponibles ");
        for(int i= 0 ; i<galeriaList.size(); i++){
            if (!galeriaList.get(i).isReservado()){
                System.out.println("Asiento "+galeriaList.get(i).TipoDeAsiento +" numero ["+galeriaList.get(i).getNumAsiento()+"]");
            }
        }
        for(int i= 0 ; i<plateaList.size(); i++){
            if (!plateaList.get(i).isReservado()){
                System.out.println("Asiento "+plateaList.get(i).TipoDeAsiento+" numero ["+
                        plateaList.get(i).getNumAsiento()+"] "+ plateaList.get(i).toString());
            }
        }
        for(int i= 0 ; i<palcoList.size(); i++){
            if (!palcoList.get(i).isReservado()){
                System.out.println("Asiento "+palcoList.get(i).TipoDeAsiento+" numero ["
                        +palcoList.get(i).getNumAsiento()+"] "+palcoList.get(i).toString());
            }
        }
    }

    @Override
    public void recaudar(ArrayList<Palco> palcoList, ArrayList<Platea> plateaList, ArrayList<Galeria> galeriaList) {
        int reservpalco = 0;
        int reservgaleria = 0;
        int reservplatea = 0;
        int cantidadpalco = 0;
        int cantidadplatea = 0;
        int cantidadgaleria = 0;
        int totalVenta;
        int totalNAsiento;
        for (int i = 0; i < galeriaList.size(); i++) {
            if (galeriaList.get(i).isReservado()) {
                reservgaleria += galeriaList.get(i).getValorAsiento();
                cantidadgaleria += 1;
            }
        }
        for (int e = 0; e < plateaList.size(); e++) {
            if (plateaList.get(e).isReservado()) {
                reservplatea += plateaList.get(e).getValorAsiento();
                cantidadplatea += 1;
            }
        }
        for (int u = 0; u < palcoList.size(); u++) {
            if (palcoList.get(u).isReservado()) {
                reservpalco += palcoList.get(u).getValorAsiento();
                cantidadpalco += 1;
            }
        }


        totalVenta = reservpalco + reservgaleria + reservplatea;
        totalNAsiento = cantidadpalco + cantidadplatea + cantidadgaleria;
        System.out.println("Se han vendido " + totalNAsiento + " asientos y se han recaudado $" + totalVenta + " Donde:");
        System.out.println(cantidadplatea + " son de platea, " + cantidadpalco + " son de palco y "
                + cantidadgaleria + " son de galeria");
    }

    @Override
    public void reservar(ArrayList<Palco> palcoList, ArrayList<Platea> plateaList, ArrayList<Galeria> galeriaList,
                         String opcion, int numeral, int menu2) {
        Scanner scan = new Scanner(System.in);
        boolean bandera = true;
        //platea tiene asientos desde el 34 al 66, galeria tiene asientos desde 1 al 33 y los demas son palco
        System.out.println("Los asientos de galeria son desde el [1 hasta el 33], platea desde [34 al 66] y palco " +
                "desde [67 al 100]");
        System.out.println("escriba el numero del asiento que desea");
        opcion=scan.nextLine();
        try {
            menu2 = Integer.parseInt(opcion);
        } catch (NumberFormatException ex) {
            System.out.println("Error !"+ ex.getMessage()+" No es un numero");
            menu2 = 100;
        }
        for (int i=0; i<palcoList.size(); i++) {
            if (palcoList.get(i).getNumAsiento() == menu2) {
                bandera = false;
                if (!palcoList.get(i).isReservado()) {
                    palcoList.get(i).setReservado(true);
                    System.out.println("Usted acaba de reservar un asiento en palco");
                } else {
                    System.out.println("No puede reservar el asiento ya que se encuentra reservado con antelacion");
                }
            }
        }
        for (int o=0; o<plateaList.size(); o++) {
            if (plateaList.get(o).getNumAsiento() == menu2) {
                bandera = false;
                if (!plateaList.get(o).isReservado()) {
                    plateaList.get(o).setReservado(true);
                    System.out.println("Usted acaba de reservar un asiento en platea");
                } else {
                    System.out.println("No puede reservar el asiento ya que se encuentra reservado con antelacion");
                }
            }
        }
        for (int u=0; u<plateaList.size(); u++) {
            if (galeriaList.get(u).getNumAsiento() == menu2) {
                bandera = false;
                if (!galeriaList.get(u).isReservado()) {
                    galeriaList.get(u).setReservado(true);
                    System.out.println("Usted acaba de reservar un asiento en galeria");
                } else {
                    System.out.println("No puede reservar el asiento ya que se encuentra reservado con antelacion");
                }
            }
        }
        if (bandera){
            System.out.println("el numero ingresado mayor a 100");
        }
    }
}
