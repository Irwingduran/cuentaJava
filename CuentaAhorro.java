public class CuentaAhorro extends Cuenta {
    private double interes;

    public CuentaAhorro(int a, double i) {
        super(a);
        interes = i;
    }

    public void agregarIntereses() {
        double balanceActual = super.getBalance();
        double interesesGanados = balanceActual * (interes/100);
        super.depositar(interesesGanados);
    }

    public String toString() {
        return super.toString() + " - Intereses = " + interes + "%";
    }
}

