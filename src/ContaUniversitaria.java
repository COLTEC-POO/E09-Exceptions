public class ContaUniversitaria extends Conta {

    public ContaUniversitaria(int numero, Cliente dono, double saldo) {
        super(numero, dono, saldo);
    }

    public void setLimite(double limite) {
        if (limite > 500 || limite < 0) {
            System.err.println("Erro no Limite");
            return;
        }
        this.limite = limite;
    }

    public double calculaTaxas(){
        double tax = 0.0;
        return tax;
    }
}