package cl.trabajo4;

public class Palco extends Asiento{
    private boolean acolchado;
    public Palco(int numAsiento, int valorAsiento, boolean reservado, String tipoDeAsiento,
                  boolean acolchado) {
        super(numAsiento, valorAsiento, reservado, tipoDeAsiento);
        this.acolchado=true;
    }

    public boolean isAcolchado() {
        System.out.println("Los asientos de palco cuentan con acolchado en asiento y apoya brazos");
        return acolchado;
    }

    public void setAcolchado(boolean acolchado) {
        this.acolchado = acolchado;
    }
}
