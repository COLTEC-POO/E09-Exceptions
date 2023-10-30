public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente dono, double saldo) {
        super(numero, dono, saldo);
    }

    public void setLimite(double limite) {
        if (limite < -100) {
            return;
        }
        this.limite = limite;
    }

    public double calculaTaxas(){

        double tax = 0.0;

        if (this.dono instanceof PessoaFisica){
            tax = 10.0;
        }

        if (this.dono instanceof PessoaJuridica){
            tax = 20.0;
        }
        return tax;
    }
} 