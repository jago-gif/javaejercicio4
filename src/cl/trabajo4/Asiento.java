package cl.trabajo4;

public class Asiento {
    protected int NumAsiento;
    protected int ValorAsiento;
    protected boolean Reservado;
    protected String TipoDeAsiento;

    public Asiento(int numAsiento, int valorAsiento, boolean reservado, String tipoDeAsiento) {
        NumAsiento = numAsiento;
        ValorAsiento = valorAsiento;
        Reservado = reservado;
        TipoDeAsiento = tipoDeAsiento;
    }

    public int getNumAsiento() {
        return NumAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        NumAsiento = numAsiento;
    }

    public int getValorAsiento() {
        return ValorAsiento;
    }

    public void setValorAsiento(int valorAsiento) {
        ValorAsiento = valorAsiento;
    }

    public boolean isReservado() {
        return Reservado;
    }

    public void setReservado(boolean reservado) {
        Reservado = reservado;
    }

    public String getTipoDeAsiento() {
        return TipoDeAsiento;
    }

    public void setTipoDeAsiento(String tipoDeAsiento) {
        TipoDeAsiento = tipoDeAsiento;
    }

}
