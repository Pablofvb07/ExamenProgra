import java.util.ArrayList;
import java.util.List;

class Parqueadero {
    private double tarifa;
    private List<String> autosIngresados;

    public Parqueadero(double tarifaInicial) {
        this.tarifa = tarifaInicial;
        this.autosIngresados = new ArrayList<>();
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public List<String> getAutosIngresados() {
        return autosIngresados;
    }

    public boolean ingresarAuto(String placa) {
        if (autosIngresados.size() < 5) {
            autosIngresados.add(placa);
            return true;
        } else {
            System.out.println("No hay espacio disponible en el parqueadero.");
            return false;
        }
    }

    public void sacarAuto(String placa) {
        autosIngresados.remove(placa);
    }

    public boolean autoEstaEnParqueadero(String placa) {
        return autosIngresados.contains(placa);
    }

    public int puestosDisponibles() {
        return 5 - autosIngresados.size();
    }
}