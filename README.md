# cuentaJava  
Usando la clase Cuenta como clase base, escriba dos clases derivadas llamadas CuentaAhorro y 
CuentaCorriente. 
• Una instancia de CuentaAhorro, además de los atributos de una instancia Cuenta, deberá 
tener una variable interés (%) y un método que agregue intereses a la cuenta. 
• Una instancia CuentaCorriente, además de los atributos de los objetos Cuenta, deberá 
tener una variable límite de sobregiro.
Asegúrese de que se hayan redefinido los métodos necesarios de la clase Cuenta en ambas clases 
derivadas. 
Ahora escriba una clase Banco (Clase principal), en la cual deberá crear un arreglo estático que 
contenga objetos de la clase CuentaAhorro y CuentaCorriente.
Escriba un método actualizar() en la clase Banco. Este iterará a través de cada cuenta, 
actualizándolas de las siguientes formas:
• En las instancias de CuentaAhorro se agregarán los intereses correspondientes (utilizando 
el método que usted escribió).
• En las instancias de CuentaCorriente se mostrará el mensaje “Cuenta con sobregiro” si la 
cuenta está sobregirada.
La clase Banco debe mostrar el menú:
1. Crear cuenta.
a. Cuenta Ahorros.
b. Cuenta Corriente.
2. Eliminar cuenta.
3. Depositar.
4. Retirar.
5. Mostrar cuentas.
6. Actualizar.
7. Salir.
Nota 1: La clase Cuenta no debe ser modificada.
Nota 2: Las opciones crear cuenta, eliminar cuenta, depositar y retirar deben verificar que la 
cuenta exista
