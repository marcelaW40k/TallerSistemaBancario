public class CuentaCorriente extends CuentaBancaria{
    private double comisionPorTransaccion;
    private double limiteSobreGiro;


    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double comisionPorTransaccion, double limiteSobreGiro) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobreGiro = limiteSobreGiro;
    }

    @Override
    public String describir() {
        String base = super.describir();
        return base + " Comisión por transacción: " + comisionPorTransaccion;
    }

    @Override
    public double calcularComision() {
        return comisionPorTransaccion;
    }

    @Override
    public void realizarRetiro(double monto) {
        double saldoActual = getSaldo() - monto;
        if (saldoActual < limiteSobreGiro){
            System.out.println("El retiro no es posible, supera el limite de sobregiro!");
        }
        setSaldo(saldoActual - comisionPorTransaccion);

    }
}
