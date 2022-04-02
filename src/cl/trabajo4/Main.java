package cl.trabajo4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeral=1;
        int opcion=0;
        int menu=0;
        ArrayList<Palco> palcoList = new ArrayList<>();
        ArrayList<Galeria>galeriaList = new ArrayList<>();
        ArrayList<Platea>plateaList = new ArrayList<>();
        for (int i=1; i<=33; i++ ){
            galeriaList.add(new Galeria(numeral,30000,false,"Galeria"));
            numeral+=1;
        }
        for (int i=1; i<=33; i++ ){
            plateaList.add(new Platea(numeral,60000,false,"Platea",true));
            numeral+=1;
        }
        for (int i=1; i<=34; i++ ){
            palcoList.add(new Palco(numeral,100000,false,"Palco",true));
            numeral+=1;
        }

        do {System.out.println("bienvenido al sistema de reserva de asientos de no se que ");
            System.out.println(" presiona [1] para reservar asiento");
            System.out.println(" presiona [2] para ver asientos disponibles");
            System.out.println(" presiona [3] para ver total recaudado");
            menu=scan.nextInt();
            switch (menu){
                case OPCION_MENU_RESERVAR:
                    IImplementarMain reserva = new ImplementarMain();
                    reserva.reservar(palcoList,plateaList,galeriaList,opcion,numeral);

                    break;
                case OPCION_MENU_DISPONIBLES:
                    IImplementarMain disponibles = new ImplementarMain();
                    disponibles.disponibles(palcoList,plateaList,galeriaList);

                    break;
                case OPCION_MENU_VER_RECAUDACIONES:
                    IImplementarMain recaudar = new ImplementarMain();
                    recaudar.recaudar(palcoList,plateaList,galeriaList);
                    break;
            }

        }while (menu != OPCION_MENU_SALIR);
    }
    //declaracion del menú
    public static final int OPCION_MENU_RESERVAR =1;
    public static final int OPCION_MENU_DISPONIBLES =2;
    public static final int OPCION_MENU_VER_RECAUDACIONES =3;
    public static final int OPCION_MENU_SALIR = 0;
    }
