package cl.trabajo4;

public class Platea extends Asiento {
    private boolean acolchado;
    public Platea(int numAsiento, int valorAsiento, boolean reservado, String tipoDeAsiento,
                   boolean acolchado) {
        super(numAsiento, valorAsiento, reservado, tipoDeAsiento);
        this.acolchado=true;
    }

    public boolean isAcolchado() {
        System.out.println("El Asiento de Platea es acolchado");
        return acolchado;
    }

    public void setAcolchado(boolean acolchado) {
        this.acolchado = acolchado;
    }

    @Override
    public String toString() {
        return "Los asientos de platea cuentan con acolchado en asiento";
    }
}
