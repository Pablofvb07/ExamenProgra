public class Tarifa extends Parqueadero {
    private double tarifain;

    public Tarifa(double tarifaInicial) {
        super(tarifaInicial);
        this.tarifain = tarifaInicial;
    }

    public double getTarifain() {
        return tarifain;
    }

    public void setTarifain(double tarifain) {
        this.tarifain = tarifain;
    }

    public void agregarTarifa(double tarifatotal) {
        this.tarifain += tarifatotal;
    }
}