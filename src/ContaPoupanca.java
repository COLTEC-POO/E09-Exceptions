public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente dono, double saldo) {
        super(numero, dono, saldo);
    }


    public void setLimite(double limite) throws IllegalArgumentException {
        if (limite > 1000 || limite < 100) {
            System.err.println("Erro De limite");
            return;
        }
        this.limite = limite;
    }

    public double calculaTaxas(){
        double tax = 0.0;
        return tax;
    }
}
