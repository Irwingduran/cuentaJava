public class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;

    public CuentaCorriente(int a, double ls) {
        super(a);
        limiteSobregiro = ls;
    }

    public void retirar(double suma) {
        double balanceActual = super.getBalance();
        if ((balanceActual - suma) < (-limiteSobregiro)) {
            System.err.println("No es posible retirar más de lo permitido.");
        } else {
            super.retirar(suma);
        }
    }

    public String toString() {
        return super.toString() + " - Límite de sobregiro = " + limiteSobregiro;
    }
}
