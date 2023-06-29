import java.util.Scanner;

public class Banco {
    private static Cuenta[] cuentas = new Cuenta[10];
    private static int numCuentas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Crear cuenta.");
            System.out.println("  a. Cuenta Ahorros.");
            System.out.println("  b. Cuenta Corriente.");
            System.out.println("2. Eliminar cuenta.");
            System.out.println("3. Depositar.");
            System.out.println("4. Retirar.");
            System.out.println("5. Mostrar cuentas.");
            System.out.println("6. Actualizar.");
            System.out.println("7. Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    eliminarCuenta();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    retirar();
                    break;
                case 5:
                    mostrarCuentas();
                    break;
                case 6:
                    actualizar();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.err.println("Opción inválida.");
                    break;
            }
        } while (opcion != 7);
    }

    private static void crearCuenta() {
        if (numCuentas < cuentas.length) {
            System.out.print("Ingrese el número de cuenta: ");
            int numCuenta = scanner.nextInt();
            System.out.print("Ingrese el tipo de cuenta (Ahorros/Ccorriente): ");
            String tipoCuenta = scanner.next();
            if (tipoCuenta.equalsIgnoreCase("Ahorros")) {
                System.out.print("Ingrese la tasa de interés: ");
                double interes = scanner.nextDouble();
                cuentas[numCuentas] = new CuentaAhorro(numCuenta, interes);
            } else if (tipoCuenta.equalsIgnoreCase("Corriente")) {
                System.out.print("Ingrese el límite de sobregiro: ");
                double limiteSobregiro = scanner.nextDouble();
                cuentas[numCuentas] = new CuentaCorriente(numCuenta, limiteSobregiro);
            } else {
                System.err.println("Tipo de cuenta inválido.");
                return;
            }
            numCuentas++;
            System.out.println("Cuenta creada exitosamente.");
        } else {
            System.err.println("No se pueden crear más cuentas.");
        }
    }

    private static void eliminarCuenta() {
        System.out.print("Ingrese el número de cuenta a eliminar: ");
        int numCuenta = scanner.nextInt();
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getNoCuenta() == numCuenta) {
                for (int j = i; j < numCuentas - 1; j++) {
                    cuentas[j] = cuentas[j+1];
                }
                cuentas[numCuentas - 1] = null;
                numCuentas--;
                System.out.println("Cuenta eliminada exitosamente.");
                return;
            }
        }
        System.err.println("Cuenta no encontrada.");
    }

    private static void depositar() {
        System.out.print("Ingrese el número de cuenta: ");
        int numCuenta = scanner.nextInt();
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getNoCuenta() == numCuenta) {
                System.out.print("Ingrese la cantidad a depositar: ");
                double cantidad = scanner.nextDouble();
                cuentas[i].depositar(cantidad);
                System.out.println("Depósito realizado exitosamente.");
                return;
            }
        }
        System.err.println("Cuenta no encontrada.");
    }

    private static void retirar() {
        System.out.print("Ingrese el número de cuenta: ");
        int numCuenta = scanner.nextInt();
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getNoCuenta() == numCuenta) {
                System.out.print("Ingrese la cantidad a retirar: ");
                double cantidad = scanner.nextDouble();
                cuentas[i].retirar(cantidad);
                System.out.println("Retiro realizado exitosamente.");
                return;
            }
        }
        System.err.println("Cuenta no encontrada.");
    }

    private static void mostrarCuentas() {
        System.out.println("\nCuentas del banco:");
        for (int i = 0; i < numCuentas; i++) {
            System.out.println(cuentas[i]);
        }
    }

    private static void actualizar() {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i] instanceof CuentaAhorro) {
                CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentas[i];
                cuentaAhorro.agregarIntereses();
            } else if (cuentas[i] instanceof CuentaCorriente) {
                CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentas[i];
                if (cuentaCorriente.getBalance() < 0) {
                    System.out.println("Cuenta con sobregiro: " + cuentaCorriente);
                }
            }
        }
    }
}