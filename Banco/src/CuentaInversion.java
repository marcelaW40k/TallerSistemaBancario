public class CuentaInversion extends CuentaBancaria{
    private double tasaAnual;
    private  int plazoMeses;
    private double penalizacionRetiroAnticipado;

    public CuentaInversion(String numeroCuenta, String titular, double saldo, double tasaAnual, int plazoMeses, double penalizacionRetiroAnticipado) {
        super(numeroCuenta, titular, saldo);
        this.tasaAnual = tasaAnual;
        this.plazoMeses = plazoMeses;
        this.penalizacionRetiroAnticipado = penalizacionRetiroAnticipado;
    }


    @Override
    public String describir(){
        String base = super.describir();
        return base + " Plazo : " + plazoMeses +" Meses - Tasa anual: " + tasaAnual + "%";
    }

    public double calcularComision(){
        return penalizacionRetiroAnticipado;
    }

    public void realizarRetiro(double monto){
        double saldoActual = getSaldo() - monto;
        setSaldo(saldoActual - calcularComision());
    }

    public  double calcularComision(int mesesTranscurridos){
       if (mesesTranscurridos >= plazoMeses){
           return 0.0;
       }
      return penalizacionRetiroAnticipado;
    }

}
