//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CuentaBancaria cuenta1  = new CuentaAhorros("12345678", "Jessica", 40000, 1.5,400000);
        CuentaBancaria cuenta2 = new CuentaCorriente("789456", "Cristian", 500000, 2000, -20);
        CuentaBancaria cuenta3 = new CuentaInversion("54678954", "Marcela", 600000, 13, 6, 20000);
        CuentaAhorros cuenta4 = new CuentaAhorros("12345678", "Jessica", 40000, 1.5,400000);
        System.out.println("___Información de cuentas Bancarias___");
        System.out.println("Cuenta de ahorros" + cuenta1.describir());
        System.out.println("Cuenta de ahorros" + cuenta2.describir());
        System.out.println(cuenta3.describir());
        System.out.println("___COMISION___");
        System.out.println(cuenta1.calcularComision());
        System.out.println(cuenta2.calcularComision());
        System.out.println(cuenta3.calcularComision());

        System.out.println("___retiro___");
        System.out.println(cuenta4.getSaldo());
        cuenta4.realizarRetiro(500000,true);
        System.out.println(cuenta4.getSaldo());
        cuenta2.realizarRetiro(500000);
        cuenta3.realizarRetiro(500000);

    }
}