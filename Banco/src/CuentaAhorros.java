public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteresMensual, double saldoMinimo) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldoMinimo = saldoMinimo;
    }

    public double getTasaInteresMensual() {
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public String describir() {
        String base = super.describir();
        return base + " Tasa mensual: " + tasaInteresMensual + "%";
    }

    @Override
    public double calcularComision() {
        double base = super.calcularComision();
        if (getSaldo() >= saldoMinimo) {
            return 0.0;
        } else {
            return 12000.0;
        }
    }

    @Override
    public void realizarRetiro(double monto) {
        setSaldo(getSaldo() - monto);
    }

    public void realizarRetiro(double monto, boolean esUrgente) {
        double saldoActual = getSaldo() - monto;
        if (esUrgente && saldoActual < saldoMinimo) {
           setSaldo( saldoActual - calcularComision());
        }
        setSaldo(saldoActual);
    }

    public double calcularInteresDelMes(){
        return (getSaldo() * tasaInteresMensual) / 100;
    }

}

