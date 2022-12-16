public class ContaPoupanca extends Conta implements ITaxas{

    public void setLimite(double limite) throws IllegalArgumentException {
        if(limite < 100 || limite > 1000){
            throw new IllegalArgumentException("O limite mínimo e máximo para Conta Poupança é R$100,00 e R$1000,00");
        }
        else{
            this.limite = limite;
        }
    }

    public double calculaTaxas() {
        return 0;
    }
}