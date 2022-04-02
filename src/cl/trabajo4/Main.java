package cl.trabajo4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeralplatea = 34;
        int numeralPalco=67;
        int numeralgaleria=1;
        int opcion=0;
        int menu=0;

        //platea tiene asientos desde el 34 al 66, galeria tiene asientos desde 1 al 33 y los demas son palco

        ArrayList<Palco>palcoList = new ArrayList<>();
        ArrayList<Galeria>galeriaList = new ArrayList<>();
        ArrayList<Platea>plateaList = new ArrayList<>();
        for (int i=1; i<=33; i++ ){
            palcoList.add(new Palco(numeralPalco,100000,false,"Palco",true));
            numeralPalco+=1;
            plateaList.add(new Platea(numeralplatea,60000,false,"Platea",true));
            numeralplatea+=1;
            galeriaList.add(new Galeria(numeralgaleria,30000,false,"Galeria"));
            numeralgaleria+=1;
        }

        palcoList.add(new Palco(100,100000,false,"Palco",true));
        do {
            System.out.println("bienvenido al sistema de reserva de asientos de no se que ");
            System.out.println(" presiona [1] para reservar asiento");
            System.out.println(" presiona [2] para ver asientos disponibles");
            System.out.println(" presiona [3] para ver total recaudado");
            menu=scan.nextInt();
            switch (menu){
                case OPCION_MENU_RESERVAR:
                    reservar(palcoList,plateaList,galeriaList,opcion);

                    break;
                case OPCION_MENU_DISPONIBLES:
                    disponibles(palcoList,plateaList,galeriaList);

                    break;
                case OPCION_MENU_VER_RECAUDACIONES:
                    recaudar(palcoList,plateaList,galeriaList);
                    break;
            }





        }while ((menu != OPCION_MENU_SALIR));



    }
    //declaracion del menú
    public static final int OPCION_MENU_RESERVAR =1;
    public static final int OPCION_MENU_DISPONIBLES =2;
    public static final int OPCION_MENU_VER_RECAUDACIONES =3;
    public static final int OPCION_MENU_SALIR = 0;



    public static void recaudar(ArrayList<Asiento> asientoArrayList){
        int reserv=0;
        int cantidad=0;
        for(int i= 0 ; i<asientoArrayList.size(); i++){
            if (asientoArrayList.get(i).isReservado()){
                reserv+=asientoArrayList.get(i).getValorAsiento();
                cantidad += 1;
            }
        }
        System.out.println("Se han vendido "+cantidad+" asientos y se a recaudado $"+reserv);
    }


    public static void disponibles(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList){
        System.out.println("Estos son los asientos disponibles ");
        for(int i= 0 ; i<galeriaList.size(); i++){
            if (!galeriaList.get(i).isReservado()){
                System.out.println("Asiento numero ["+galeriaList.get(i).getNumAsiento()+"]");
            }
        }
        for(int i= 0 ; i<plateaList.size(); i++){
            if (!plateaList.get(i).isReservado()){
                System.out.println("Asiento numero ["+plateaList.get(i).getNumAsiento()+"]");
            }
        }
        for(int i= 0 ; i<palcoList.size(); i++){
            if (!palcoList.get(i).isReservado()){
                System.out.println("Asiento numero ["+palcoList.get(i).getNumAsiento()+"]");
            }
        }
    }
    public static void recaudar(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList) {
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

    public static void reservar(ArrayList<Palco> palcoList, ArrayList<Platea>plateaList, ArrayList<Galeria>galeriaList,
                                int opcion){
        Scanner scan = new Scanner(System.in);
        boolean bandera = true;
        //platea tiene asientos desde el 34 al 66, galeria tiene asientos desde 1 al 33 y los demas son palco
        System.out.println("Los asientos de galeria son desde el [1 hasta el 33], platea desde [34 al 66] y palco " +
                "desde [67 al 100]");
        System.out.println("escriba el numero del asiento que desea");
        opcion=scan.nextInt();
        for (int i=0; i<palcoList.size()&&i<galeriaList.size()&&i<plateaList.size(); i++) {
            if (palcoList.get(i).getNumAsiento() == opcion) {
                bandera = false;
                if (!palcoList.get(i).isReservado()) {
                    palcoList.get(i).setReservado(true);
                    System.out.println("Usted acaba de reservar un asiento en palco");
                } else {
                    System.out.println("No puede reservar el asiento ya que se encuentra reservado con antelacion");
                }
            } else if (plateaList.get(i).getNumAsiento() == opcion) {
                bandera = false;
                if (!plateaList.get(i).isReservado()) {
                    plateaList.get(i).setReservado(true);
                    System.out.println("Usted acaba de reservar un asiento en platea");
                } else {
                    System.out.println("No puede reservar el asiento ya que se encuentra reservado con antelacion");
                }
            } else if (galeriaList.get(i).getNumAsiento() == opcion) {
                bandera = false;
                if (!galeriaList.get(i).isReservado()) {
                    galeriaList.get(i).setReservado(true);
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
